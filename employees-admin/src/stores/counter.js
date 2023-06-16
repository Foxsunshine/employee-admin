import { defineStore } from "pinia";

export const useCounterStore = defineStore({
  id: "counter",
  state: () => ({
    // Used for manage all the api
    getUrl: "http://localhost:8080/api/employees",
    postUrl: "http://localhost:8080/api/create",
    updateUrl: "http://localhost:8080/api/update/",
    deleteUrl: "http://localhost:8080/api/delete/",
    uploadImgUrl: "http://localhost:8080/upload",

    // Used for loading all data
    // すべてのデータをロードする
    allDatas: {},

    // Used for storing id when updating
    // 更新時にIDを保存する
    updateId: 0,
    // Used for storing id when deleting
    // 削除時にIDを保存する
    deleteId: 0,

    // Used for creating, updating data
    // データの作成、更新に使用
    newData: {
      name: "aiful",
      email: "aiful@aiful.com",
      image: "1.jpeg",
    },

    // Used for manage the "Confirm" button should navigate to.
    // "Confirm"ボタンがナビゲートすべき場所を管理する
    confirmTo: "",
  }),

  actions: {
    // Loading existing data in the database
    // データベースの既存データをロードする
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
          return this.allDatas;
        })
        .catch((err) => console.error(err));
    },

    // Inserting new data into the database
    // データベースに新データを挿入する
    insertData() {
      fetch(this.postUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.newData),
      })
        .then((response) => response.text())
        .then((msg) => console.log(msg))
        .catch((error) => console.error("Error:", error));
    },

    // Function to handle Image uploads
    // 画像アップロードを処理する関数
    uploadFile(event) {
      let file = event.target.files[0];
      let formData = new FormData();
      formData.append("file", file);

      fetch(this.uploadImgUrl, {
        method: "POST",
        body: formData,
      })
        .then((response) => response.text())
        .then((path) => {
          this.newData.image = path;
        })
        .catch((error) => {
          console.error(error);
        });
    },

    // Updating data in the database
    // データベースのデータを更新する
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

    // Deleting data in the database
    // データベースからデータを削除する
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

    // Determining where the "Confirm" button should navigate to.
    // "Confirm"ボタンがナビゲートする場所を決定する
    setConfirmToCreate() {
      this.confirmTo = "create";
    },
    setConfirmToUpdate() {
      this.confirmTo = "update";
    },

    // the current updating id
    // 現在更新中のID
    setUpdateId(id) {
      this.updateId = id;
    },
    // the current deleting id
    // 現在削除中のID
    setDeleteId(id) {
      this.deleteId = id;
    },
    // set the updating new data
    // 更新する新しいデータを設定する
    setNewData(name, email, image) {
      this.newData.name = name;
      this.newData.email = email;
      this.newData.image = image;
    },
    // set the updating new img
    // 更新する新しい画像を設定する
    setNewImage(img) {
      this.newImage = img;
    },
  },
});
