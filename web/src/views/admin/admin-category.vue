<template>
  <a-layout>
    <a-layout-content
        :style="{ background: '#fff', padding: '24px', margin: 0, minHeight: '280px' }"
    >
      <p>
        <a-form layout="inline" :model="param">
          <a-form-item>
            <a-button type="primary" @click="handleQuery()">
              查询
            </a-button>
          </a-form-item>
          <a-form-item>
            <a-button type="primary" @click="add()">
              新增
            </a-button>
          </a-form-item>
        </a-form>
      </p>
      <a-table
          :columns="columns"
          :row-key="record => record.id"
          :data-source="level1"
          :loading="loading"
          :pagination="false"
      >

        <template v-slot:action="{ text, record }">
          <a-space size="small">
            <a-button type="primary" @click="edit(record)">
              编辑
            </a-button>
            <a-popconfirm
                title="删除后不可恢复，确认删除?"
                ok-text="是"
                cancel-text="否"
                @confirm="handleDelete(record.id)"
            >
              <a-button type="danger">
                删除
              </a-button>
            </a-popconfirm>

          </a-space>
        </template>
      </a-table>
    </a-layout-content>
  </a-layout>

  <a-modal
      title="分类表单"
      v-model:visible="modalVisible"
      :confirm-loading="modalLoading"
      @ok="handleModalOk"
  >
    <a-form :model="category" :label-col="{ span: 6 }" :wrapper-col="{ span: 18 }">
      <a-form-item label="名称">
        <a-input v-model:value="category.name"/>
      </a-form-item>
      <a-form-item label="父分类">
        <a-select
            v-model:value="category.parent"
            ref="select"
        >
          <a-select-option value="0">无</a-select-option>
          <a-select-option v-for="c in level1" :key="c.id" :value="c.id" :disabled="category.id===c.id">{{ c.name }}</a-select-option>
        </a-select>
      </a-form-item>
      <a-form-item label="顺序">
        <a-input v-model:value="category.sort" />
      </a-form-item>
    </a-form>
  </a-modal>
</template>

<script lang="ts">
import {defineComponent, onMounted, ref} from 'vue';
import axios from 'axios';
import {message} from "ant-design-vue";
import {Tool} from "@/util/tool";

export default defineComponent({
  name: 'AdminCategory',
  setup() {
    const param = ref();
    const level1 = ref();
    param.value = {};
    const categorys = ref();

    const loading = ref(false);

    const columns = [
      {
        title: '名称',
        dataIndex: 'name'
      },
      {
        title: '父分类',
        key:"parent",
        dataIndex: 'parent'
      },
      {
        title: '顺序',
        dataIndex: 'sort'
      },
      {
        title: 'Action',
        key: 'action',
        slots: {customRender: 'action'}
      }
    ];

    /**
     * 数据查询
     **/
    const handleQuery = () => {
      loading.value = true;
      // 如果不清空现有数据，则编辑保存重新加载数据后，再点编辑，则列表显示的还是编辑前的数据
      axios.get("/category/all").then((response) => {
        loading.value = false;
        const data = response.data;
        if (data.success) {
          categorys.value = data.content;


          level1.value = []
          level1.value=Tool.array2Tree(categorys.value,0)

        } else {
          message.error(data.message)
        }
      });
    };


    // -------- 表单 ---------
    const category = ref({})
    const modalVisible = ref(false);
    const modalLoading = ref(false);
    const handleModalOk = () => {
      modalLoading.value = true;
      axios.post("/category/save", category.value).then((response) => {
        modalLoading.value = false;
        const data = response.data;
        if (data.success) {
          modalVisible.value = false;
          //重新加载列表
          handleQuery();
        } else {
          message.error(data.message)
        }
      });
    };

    /**
     * 编辑
     */
    const edit = (record: any) => {
      modalVisible.value = true;
      category.value = Tool.copy(record)
    };

    /**
     * 新增
     */
    const add = () => {
      modalVisible.value = true;
      category.value = {}
    };

    /**
     * 删除
     */
    const handleDelete = (id: number) => {
      axios.delete("/category/delete/" + id).then((response) => {
        const data = response.data;
        if (data.success) {
          //重新加载列表
          handleQuery()
        }
      });
    };

    onMounted(() => {
      handleQuery();
    });

    return {
      categorys,
      columns,
      loading,
      param,
      level1,
      handleQuery,

      add,
      edit,
      handleDelete,

      category,
      modalVisible,
      modalLoading,
      handleModalOk
    }
  }
});
</script>





