<script setup>
import { useCounterStore } from "@/stores/counter";
const counter = useCounterStore();
</script>

<template>
  <router-link to="/employees"
    ><button
      type="button"
      class="btn btn-primary"
      @click="
        counter.confirmTo == 'create'
          ? counter.insertData()
          : counter.updateData()
      "
    >
      登録
    </button>
  </router-link>
</template>
