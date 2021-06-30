<template>
  <a-layout>
    <a-layout-content style="background: #fff;padding: 24px;margin: 0;min-height: 200px">
      <a-row>
        <a-col :span="6">
          <a-tree
              v-if="level1.length>0"
              :tree-data="level1"
              @select="onSelect"
              :replace-fields="{title: 'name',key: 'id',children: 'children'}"
              :defaultExpandAll="true"
          >
          </a-tree>
        </a-col>
        <a-col :span="18">
          <div :innerHTML="html"></div>
        </a-col>
      </a-row>
    </a-layout-content>
  </a-layout>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from "vue";
import {message} from "ant-design-vue";
import axios from "axios";
import {Tool} from "@/util/tool";
import {useRoute} from "vue-router";
export default defineComponent({
  name: 'doc',
  setup: function () {
    const html = ref()
    const level1 = ref();
    level1.value = [];
    const route = new useRoute()
    const handleQuery = () => {
      axios.get("/doc/all/" + route.query.ebookId).then((response) => {
        const data = response.data;
        if (data.success) {
          level1.value = Tool.array2Tree(data.content, 0);
          console.log(level1.value);
        } else {
          message.error(data.message);
        }
      })
    }

    /**
     * 内容查询
     **/
    const handleQueryContent = (id:number) => {
      axios.get("/doc/find-content/" + id).then((response) => {
        const data = response.data;
        if (data.success) {
          html.value=data.content
        } else {
          message.error(data.message);
        }
      });
    };

    const onSelect=(selectedKeys:any,info:any)=>{
      if (Tool.isNotEmpty(selectedKeys)) {
        handleQueryContent(selectedKeys[0])
      }
    }

    onMounted(() => {
      handleQuery();
    })
    return {
      level1,
      html,
      onSelect
    }
  }
})
</script>