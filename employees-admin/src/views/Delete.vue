<script setup>
import { ref, onMounted, computed } from "vue";
import { useCounterStore } from "@/stores/counter";
import { useRoute, useRouter } from "vue-router";
import CancelButton from "@/components/CancelButton.vue";
import DeleteButton from "../components/DeleteButton.vue";
import TheNavigationForDelete from "@/components/TheNavigationForDelete.vue";
const router = useRouter();
const route = useRoute();
const counter = useCounterStore();

const id = ref(route.params.id);
const newData = ref({});

const imgUrl = computed(() => {
  return newData.value.image
    ? "http://localhost:8080/images/" + newData.value.image
    : "http://localhost:8080/images/1.jpeg";
});

onMounted(async () => {
  await counter.loadData();
  newData.value = counter.allDatas.find((data) => data.id == id.value);
});
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
          :value="id"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">名前</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="newData.name"
        />
      </div>
      <div class="mb-3">
        <label for="name" class="form-label">Email</label>
        <input
          readonly
          type="text"
          class="form-control-plaintext"
          :value="newData.email"
        />
      </div>
      <div class="mb-3">
        <p>Image</p>
        <img :src="imgUrl" class="img-fluid rounded-circle" />
      </div>
      <div class="d-grid gap-2 d-md-flex justify-content-md-center">
        <DeleteButton />
        <CancelButton />
      </div>
    </form>
  </div>
</template>
<style scoped>
img {
  object-fit: cover;
  width: 100px;
  height: 100px;
}
</style>
