<template>
  <a-layout>
      <the-header />
      <router-view />
      <the-footer />
  </a-layout>
</template>

<script lang="ts">
import TheHeader from '@/components/the-header.vue';
import TheFooter from '@/components/the-footer.vue';
import { defineComponent, ref } from 'vue';
export default defineComponent({
  name:'app',
  components: {
    TheHeader,
    TheFooter,
  },
  setup() {
    return {
      selectedKeys1: ref<string[]>(['2']),
      selectedKeys2: ref<string[]>(['1']),
      collapsed: ref<boolean>(false),
      openKeys: ref<string[]>(['sub1']),
    };
  },
});
</script>
