<script setup>
import { ref } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import ConfirmButton from "../components/ConfirmButton.vue";

const router = useRouter();
const route = useRoute();
const counter = useCounterStore();

const id = ref(counter.updateId);
const name = ref(counter.newData.name);
const email = ref(counter.newData.email);
</script>
<template>
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">Id</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          id="name"
          :value="id"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input v-model="name" type="text" class="form-control" id="name" />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input v-model="email" type="email" class="form-control" id="name" />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <ConfirmButton @click="counter.setNewData(name, email)" />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
