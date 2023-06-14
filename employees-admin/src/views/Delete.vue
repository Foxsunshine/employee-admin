<script setup>
import { ref, onMounted, onUnmounted } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import DeleteButton from "../components/DeleteButton.vue";
import TheNavigationForDelete from "@/components/TheNavigationForDelete.vue";
const router = useRouter();
const route = useRoute();
const counter = useCounterStore();
</script>
<template>
  <TheNavigationForDelete />
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">Id</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="counter.deleteId"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="counter.newData.name"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="counter.newData.email"
        />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <DeleteButton />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
