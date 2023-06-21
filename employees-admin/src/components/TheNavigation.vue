<script setup>
import { useCounterStore } from "../stores/counter";
const counter = useCounterStore();
</script>

<template>
  <div id="nav">
    <h1 id="logo">研修生一覧</h1>
    <div class="link">
      <router-link id="create" to="/create" @click="counter.setConfirmToCreate"
        >新規登録</router-link
      >
    </div>
  </div>
</template>

<style scoped>
#nav {
  justify-content: space-between;
}
</style>
