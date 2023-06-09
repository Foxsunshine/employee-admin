<script setup>
import { ref } from "vue";
import { useCounterStore } from "@/stores/counter";
import { defineProps } from "vue";
const url = "http://localhost:8080/api/create";
const props = defineProps({
  newData: Object,
});
const counter = useCounterStore();

function confirmNewEmployee() {
  fetch(url, {
    method: "POST",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(counter.$state.newData),
  })
    .then((response) => response.text())
    .then((newData) => console.log(newData))
    .catch((error) => console.error("Error:", error));
}
</script>

<template>
  <router-link to="/employees"
    ><button type="button" class="btn btn-primary" @click="confirmNewEmployee">
      登録
    </button>
  </router-link>
</template>
