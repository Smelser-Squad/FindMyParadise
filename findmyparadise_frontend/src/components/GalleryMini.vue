<template>
<div>
    <div class="row">
        <div class="left">
            <img class="leftImage" :src="firstImage" @click="() => TogglePopup('buttonTrigger')">
        </div>
        <div class="rightSide">
            <img class="rightTop" :src="secondImage" @click="() => TogglePopup('buttonTrigger')">
            <img class="rightTopR" :src="thirdImage" @click="() => TogglePopup('buttonTrigger')">
            <img class="rightBot" :src="fourthImage" @click="() => TogglePopup('buttonTrigger')">
            <img class="rightBotR" :src="fifthImage" @click="() => TogglePopup('buttonTrigger')">
        </div>
    </div>

    <Modal v-if="popupTriggers.buttonTrigger" class="modal" 
               :TogglePopup="() => TogglePopup('buttonTrigger')">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner" v-for="image in images" :key="image">
                    <div class="carousel-item active">
                        <img :src="image.imageSrc" class="d-block w-100" alt="">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
    </Modal>
</div>
</template>


<script>
import { ref } from "vue";
import axios from "axios";
import Modal from "./Modal";

let listingId = 1;
export default {
    components: { Modal },
    name: "carousel",
    setup() {
        const popupTriggers = ref({
        buttonTrigger: false,
        });

        const TogglePopup = (trigger) => {
            popupTriggers.value[trigger] = !popupTriggers.value[trigger];
        };

        return {
            Modal,
            popupTriggers,
            TogglePopup,
        };
    },
    data(){
        return {
            images: {},
            firstImage : String,
            secondImage: String,
            thirdImage: String,
            fourthImage: String,
            fifthImage: String
        };
    },
    mounted(){
        axios.get(`http://localhost:8080/api/gallery/listing/${listingId}`).then((res) => {
            this.images = res.data;
            console.log(this.images);
            this.firstImage = res.data[0].imageSrc;
            this.secondImage = res.data[1].imageSrc;
            this.thirdImage = res.data[2].imageSrc;
            this.fourthImage = res.data[3].imageSrc;
            this.fifthImage = res.data[4].imageSrc;

        })
    },
    methods(){

    }
};
</script>


<style scoped>
    .rightSide{
        width: 50%;
        height: 100%;
    }
    .left{
        width: 50%;
        height: 100%;
        overflow: hidden;
    }
    .leftImage{
        border-right: 4px solid #FFFFFF;
        object-fit: cover;
        transform: translateX(-20%);
        transform: translateY(-20%);
        }
    .rightTop{
        width: 50%;
        height: 50%;
        border-left: 4px solid #FFFFFF;
        border-bottom: 4px solid #FFFFFF;  
        border-right: 4px solid #FFFFFF;
        object-fit: fill;
        overflow:hidden;
    }
    .rightTopR{
        width: 50%;
        height: 50%;
        border-left: 4px solid #FFFFFF;
        border-bottom: 4px solid #FFFFFF;
        object-fit: fill;
        overflow: hidden;
    }
    .rightBot{
        width: 50%;
        height: 50%;
        border-left: 4px solid #FFFFFF;
        border-top: 4px solid #FFFFFF;
        border-right: 4px solid #FFFFFF;
        object-fit: fill;
        overflow: hidden;
    }
    .rightBotR{
        width: 50%;
        height: 50%;
        border-left: 4px solid #FFFFFF;
        border-top: 4px solid #FFFFFF;
        object-fit: cover;
        overflow: hidden;
    }
    .row{
        border-radius: 5px;
        object-fit: fill;
    }
    .carousel-item{
        object-fit: fill;
    }
    .carousel{
        margin: 15px;
        
    }
    .modal{
        overflow: hidden;

    }
    
    

    
</style>