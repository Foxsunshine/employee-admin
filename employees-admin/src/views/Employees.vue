<script setup>
import Table from "@/components/Table.vue";
import { useCounterStore } from "@/stores/counter";

const counter = useCounterStore();

const count = counter.$state.count;
const increment = counter.increment;
</script>
<template>
  <Table />
  <button @click="increment">{{ counter.$state.count }}</button>
</template>
