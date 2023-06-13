<script setup>
import { useCounterStore } from "@/stores/counter";
const counter = useCounterStore();
console.log(counter.confirmTo);
</script>

<template>
  <router-link to="/employees"
    ><button type="button" class="btn btn-danger" @click="counter.deleteData">
      削除
    </button>
  </router-link>
</template>
