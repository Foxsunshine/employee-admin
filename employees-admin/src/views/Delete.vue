<script setup>
import { ref } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import DeleteButton from "../components/DeleteButton.vue";

const router = useRouter();
const route = useRoute();
const counter = useCounterStore();

const id = ref(route.query.id);
const name = ref(route.query.name);
const email = ref(route.query.email);

console.log(name.value);

function setNewData() {
  counter.setNewData(name.value, email.value);
  counter.setUpdateId(id.value);
}
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
          :value="id"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="name"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="email"
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
