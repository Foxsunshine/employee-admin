<script setup>
import { ref, watch, computed } from "vue";

// define props
const props = defineProps({
  totalPages: {
    type: Number,
    required: true,
  },
  initialPage: {
    type: Number,
    default: 1,
  },
});

// define emits
const emit = defineEmits(["update:currentPage"]);

let currentPage = ref(props.initialPage);
const preButton = ref(null);
const nextButton = ref(null);

const surroundingPages = 1;
const startPage = computed(() => {
  let start = currentPage.value - surroundingPages;
  return Math.max(start, 2);
});
const endPage = computed(() => {
  let end = currentPage.value + surroundingPages;
  return Math.min(end, props.totalPages - 1);
});

const pages = computed(() => {
  const range = [];
  for (let i = startPage.value; i <= endPage.value; i++) {
    range.push({ name: i, isDisabled: i === currentPage.value });
  }
  return range;
});

const previousPage = () => {
  if (currentPage.value > 1) {
    currentPage.value--;
    preButton.value.blur();
  }
};

const nextPage = () => {
  if (currentPage.value < props.totalPages) {
    currentPage.value++;
    nextButton.value.blur();
  }
};

const changePage = (page) => {
  currentPage.value = page;
};

watch(currentPage, (newVal) => {
  emit("update:currentPage", newVal);
});
</script>

<template>
  <ul class="pagination" v-if="totalPages !== 1">
    <li class="page-item" :class="{ disabled: currentPage === 1 }">
      <button class="page-link" @click="previousPage" ref="preButton">
        &laquo;
      </button>
    </li>
    <li class="page-item" :class="{ active: currentPage === 1 }">
      <button
        class="page-link"
        type="button"
        :disabled="currentPage === 1"
        @click="changePage(1)"
      >
        1
      </button>
    </li>
    <li class="page-item disabled" v-if="startPage > 2">
      <span class="page-link">...</span>
    </li>
    <li
      class="page-item"
      v-for="page in pages"
      :key="page.name"
      :class="{ active: page.name === currentPage }"
    >
      <button
        class="page-link"
        type="button"
        :disabled="page.isDisabled"
        @click="changePage(page.name)"
      >
        {{ page.name }}
      </button>
    </li>
    <li class="page-item disabled" v-if="endPage < totalPages - 1">
      <span class="page-link">...</span>
    </li>
    <li class="page-item" :class="{ active: currentPage === totalPages }">
      <button
        class="page-link"
        type="button"
        :disabled="currentPage === totalPages"
        @click="changePage(totalPages)"
      >
        {{ totalPages }}
      </button>
    </li>
    <li class="page-item" :class="{ disabled: currentPage === totalPages }">
      <button class="page-link" @click="nextPage" ref="nextButton">
        &raquo;
      </button>
    </li>
  </ul>
  <button class="page-link" type="button" v-if="totalPages === 1" disabled>
    1
  </button>
</template>
<style scoped>
.pagination {
  position: relative;
}
.btn {
  background-color: #373737 !important;
  color: #373737 !important;
}

.btn:hover,
.btn:focus {
  background-color: #3d3d3d !important;
  color: #3d3d3d !important;
}

.page-link {
  color: #373737 !important;
}

.page-link:hover,
.page-link:focus {
  color: #3d3d3d !important;
}

.page-item.active .page-link {
  background-color: #e9e9e9 !important;
  border-color: #e9e9e9 !important;
}
</style>
