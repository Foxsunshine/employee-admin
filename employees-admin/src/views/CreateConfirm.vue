<script setup>
import { useCounterStore } from "@/stores/counter";
import RegisterButton from "../components/RegisterButton.vue";
import CancelButton from "../components/CancelButton.vue";

const counter = useCounterStore();
</script>
<template>
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <p>名前</p>
        <p>{{ counter.newData.name }}</p>
      </div>
      <div class="mb-3">
        <p>Email</p>
        <p>{{ counter.newData.email }}</p>
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <RegisterButton />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped>


</style>
