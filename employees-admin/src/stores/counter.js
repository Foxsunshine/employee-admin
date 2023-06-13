import { defineStore } from "pinia";

export const useCounterStore = defineStore({
  // 唯一的 id
  id: "counter",

  // store 的 state
  state: () => ({
    confirmTo: "",
    getUrl: "http://localhost:8080/api/employees",
    postUrl: "http://localhost:8080/api/create",
    updateUrl: "http://localhost:8080/api/update/",
    deleteUrl: "http://localhost:8080/api/delete/",

    //用于加载所有数据
    allDatas: {},

    //用于更新时储存id
    updateId: 0,
    //用于更新时储存id
    deleteId: 0,
    //用于创建，更新数据
    newData: {
      name: "",
      email: "",
    },
  }),

  // store 的 actions
  actions: {
    //用于加载数据库现有数据
    loadData() {
      return fetch(this.getUrl)
        .then((res) => {
          if (!res.ok) {
            throw new Error("network error.we couldn't call api.");
          }
          return res.json();
        })
        .then((jsonData) => {
          this.allDatas = jsonData;
          console.log(this.allDatas);
          return this.allDatas;
        })
        .catch((err) => console.error(err));
    },

    //用于向数据库插入新数据
    insertData() {
      console.log("uploading...");
      fetch(this.postUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.newData),
      })
        .then((response) => response.text())
        .then((newData) => console.log(newData))
        .catch((error) => console.error("Error:", error));
    },

    //更新数据库数据
    updateData() {
      console.log("updating...");
      const updateUrl = this.updateUrl + this.updateId.toString();
      console.log(updateUrl);
      fetch(updateUrl, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.newData),
      })
        .then((response) => response.text())
        .then((newData) => console.log(newData))
        .catch((error) => console.error("Error:", error));
    },

    //删除数据库数据
    deleteData() {
      console.log("deleting...");
      const deleteUrl = this.deleteUrl + this.deleteId.toString();
      console.log(deleteUrl);
      fetch(deleteUrl, {
        method: "DELETE",
      })
        .then((response) => response.text())
        .then((deletedData) => console.log(deletedData))
        .catch((error) => console.error("Error:", error));
    },

    // 用于“确认”按键导向哪个页面。
    setConfirmToCreate() {
      this.confirmTo = "create";
    },
    setConfirmToUpdate() {
      this.confirmTo = "update";
    },

    //更新当前id
    setUpdateId(id) {
      this.updateId = id;
    },
    setDeleteId(id) {
      this.deleteId = id;
    },
    //用于更新数据
    setNewData(name, email) {
      this.newData.name = name;
      this.newData.email = email;
    },
  },
});
