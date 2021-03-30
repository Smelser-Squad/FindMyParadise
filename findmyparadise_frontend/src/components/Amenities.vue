<template>
    <div id="Amenities">
        <h3>Amenities</h3>
        <ul>
            <li v-for="amenity in amenities" :key="amenity">
                {{amenity.amenityName}}
            </li>
        </ul>

        <button class="showBtn" @click="() => TogglePopup('buttonTrigger')">
            Show all {{amenities.length}} amenities
        </button>
        
        <Modal v-if="popupTriggers.buttonTrigger" 
               :TogglePopup="() => TogglePopup('buttonTrigger')">
            <h3>Amenities</h3>
            <br>
            <ul>
                <li v-for="amenity in amenities" :key="amenity">
                    {{amenity.amenityName}}
                    <hr>
                </li>
                
            </ul>
        </Modal>
        
    </div>
</template>

<script>
    import { ref } from 'vue';
    import axios from 'axios';
    import Modal from './Modal';

    export default {
    components: { Modal },
        name: "Amenities",
        setup() {

            const popupTriggers = ref({
                buttonTrigger: false
            });

            const TogglePopup = (trigger) => {
                popupTriggers.value[trigger] = !popupTriggers.value[trigger]
            }

            return {
                Modal,
                popupTriggers,
                TogglePopup
            }
        },
        data() {
            return {
                amenities: [],
                amenityName: "",
            }
        },
        mounted() {
            axios
                .get("http://localhost:8080/api/amenities")
                .then((res) => {
                    console.log(res.data);
                    this.amenities = res.data;
                })
                .catch((err) => Promise.reject(err));
        }
    }
</script>

<style scoped>
ul {
  list-style-type: none;
}

.showBtn {
  border-radius: 12px;
  background-color: white;
  padding: 10px;
  border: 1px solid;
}

.showBtn:hover {
  text-decoration: underline;
  background-color: #f7f7f7;
}
</style>
