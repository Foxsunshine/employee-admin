<script setup>
import { ref, computed, onMounted } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import ConfirmButton from "@/components/ConfirmButton.vue";
import TheNavigationForUpdate from "@/components/TheNavigationForUpdate.vue";
const route = useRoute();
const counter = useCounterStore();

const id = ref(route.params.id);
const newData = ref({});

onMounted(async () => {
  await counter.loadData();
  newData.value = counter.allDatas.find((data) => data.id == id.value);
});

const emailInputTouched = ref(false);

const isValidEmail = computed(() => {
  if (!emailInputTouched.value) {
    return true;
  }
  const re = /\S+@\S+\.\S+/;
  return re.test(email.value);
});

const imgUrl = computed(() => {
  return newData.value.image
    ? "http://localhost:8080/images/" + newData.value.image
    : "http://localhost:8080/images/1.jpeg";
});

function setData() {
  counter.setUpdateId(id);
  counter.setNewData(
    newData.value.name,
    newData.value.email,
    newData.value.image
  );
}
</script>
<template>
  <TheNavigationForUpdate />
  <div>
    <form class="row g-3">
      <div class="mb-3">
        <label for="name" class="form-label">Id</label>
        <p class="form-control-plaintext">{{ id }}</p>
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          v-model="newData.name"
          type="text"
          class="form-control"
          id="name"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          v-model="newData.email"
          @input="emailInputTouched = true"
          type="email"
          class="form-control"
          id="name"
        />
        <p v-if="!isValidEmail" style="color: red">
          Please enter a valid email.
        </p>
      </div>
      <div class="mb-3">
        <p>Image</p>
        <img :src="imgUrl" class="img-fluid rounded-circle" />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <ConfirmButton @click="setData()" :disabled="!isValidEmail" />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped></style>
