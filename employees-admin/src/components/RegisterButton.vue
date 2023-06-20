<script setup>
import { useCounterStore } from "@/stores/counter";
const counter = useCounterStore();
</script>

<template>
  <button type="button" class="btn btn-primary">登録</button>
</template>
