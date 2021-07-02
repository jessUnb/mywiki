<template>
  <a-layout-footer style="text-align: center">
    MyWiki ，欢迎 {{user.name}}
  </a-layout-footer>
</template>

<script>
import {computed} from "vue";
import store from "@/store";

export default {
  name: "the-footer",
  setup() {
    const user=computed(()=> store.state.user)

    return {
      user
    }
  }
}
</script>

<style scoped>

</style>