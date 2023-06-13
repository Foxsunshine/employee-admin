<script setup>
import { useCounterStore } from "../stores/counter";
const counter = useCounterStore();
</script>

<template>
  <div id="nav">
    <router-link id="logo" to="/employees">研修生一覧</router-link>
    <div class="link">
      <router-link id="create" to="/create" @click="counter.setConfirmToCreate"
        >新規登録</router-link
      >
    </div>
  </div>
</template>

<style scoped></style>
