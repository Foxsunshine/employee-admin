<script setup>
import { ref } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import UpdateConfirmButton from "../components/UpdateConfirmButton.vue";

// 使用路由
const router = useRouter();

// 使用当前激活的路由
const route = useRoute();

const id = ref(route.query.id);
const name = ref(route.query.name);
const email = ref(route.query.email);
const updateName = ref("");
const updateEmail = ref("");

const counter = useCounterStore();

function showUpdate() {
  console.log(updateName.value, updateEmail.value);
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
          id="name"
          :value="id"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          v-model="updateName"
          type="text"
          class="form-control"
          id="name"
          :placeholder="name"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          v-model="updateEmail"
          type="email"
          class="form-control"
          id="name"
          :placeholder="email"
        />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <UpdateConfirmButton
          :newData="{ name: updateName, email: updateEmail }"
          :id="id"
        />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
