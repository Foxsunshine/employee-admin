<script setup>
import { useCounterStore } from "@/stores/counter";
const counter = useCounterStore();
</script>

<template>
  <router-link
    :to="counter.confirmTo == 'create' ? '/create_confirm' : '/update_confirm'"
    ><button type="button" class="btn btn-outline-secondary">確認</button>
  </router-link>
</template>
