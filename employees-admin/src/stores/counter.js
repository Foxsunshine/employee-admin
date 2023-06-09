import {defineStore} from 'pinia'

export const useCounterStore = defineStore({
    // 唯一的 id
    id: 'counter',
  
    // store 的 state
    state: () => ({
      count: 0,
      updateId:0,
      newData:{
        name:'',
        email:''
      }

    }),
  
    // store 的 actions
    actions: {
      increment() {
        console.log(this.count)
        this.count++
      },
      setNewData(name,email){
        this.newData.name = name;
        this.newData.email = email;
      },
      setUpdateId(id){
        this.updateId = id;
      }
    }
  })