<script setup>
import { ref } from "vue";

const datas = ref({});

fetch("http://localhost:8080/api/employees")
  .then((res) => {
    if (!res.ok) {
      throw new Error("network error.we couldn't call api.");
    }
    return res.json();
  })
  .then((jsonData) => {
    datas.value = jsonData;
    console.log(datas);
    // datas.value.forEach(addRow);
  })
  .catch((err) => console.error(err));

// function addRow(data) {
//   const table = document.getElementById("myTable");
//   const tbody = table.getElementsByTagName("tbody")[0];
//   const rowHTML = `
//         <tr>
//             <td>${data.id}</td>
//             <td>${data.name}</td>
//             <td>${data.email}</td>
//             <td>🗑️</td>
//             <td>✏️</td>
//         </tr>
//     `;
//   tbody.innerHTML += rowHTML;
// }
</script>

<template>
  <table id="myTable" class="table table-hover">
    <thead>
      <tr>
        <th scope="col">ID</th>
        <th scope="col">名前</th>
        <th scope="col">メールアドレス</th>
        <th scope="col">削除</th>
        <th scope="col">編集</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="data in datas" :key="data.id">
        <td>{{ data.id }}</td>
        <td>{{ data.name }}</td>
        <td>{{ data.email }}</td>
        <td><a href="">🗑️</a></td>
        <td>
          <router-link
            :to="{
              path: 'update',
              query: { id: data.id, name: data.name, email: data.email },
            }"
            >✏️</router-link
          >
        </td>
      </tr>
    </tbody>
  </table>
</template>
