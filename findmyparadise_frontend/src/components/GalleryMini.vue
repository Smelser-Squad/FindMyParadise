<template>
    <div class="row">
        <div class="left">
            <img class="leftImage" src="https://a0.muscache.com/im/pictures/36283cf5-95c8-4c70-800f-b1c5a9a6f5a0.jpg?im_w=1200" @click="() => TogglePopup('buttonTrigger')">
        </div>
        <div class="rightSide">
            <img class="rightTop" src="https://a0.muscache.com/im/pictures/73b354de-ca65-45a4-a492-a6f8c922edc2.jpg?im_w=720" @click="() => TogglePopup('buttonTrigger')">
            <img class="rightTopR" src="https://a0.muscache.com/im/pictures/d4a660ca-31ea-41d0-94bd-d277657d170a.jpg?im_w=720" @click="() => TogglePopup('buttonTrigger')">
            <img class="rightBot" src="https://a0.muscache.com/im/pictures/15d1a761-3e20-4631-83ca-32594fa88975.jpg?im_w=1440" @click="() => TogglePopup('buttonTrigger')">
            <img class="rightBotR" src="https://a0.muscache.com/im/pictures/939d189e-560e-49fd-aa01-b0f26740b786.jpg?im_w=720" @click="() => TogglePopup('buttonTrigger')">
        </div>
    </div>

    <Modal v-if="popupTriggers.buttonTrigger" class="modal" 
               :TogglePopup="() => TogglePopup('buttonTrigger')">
            <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img src="https://a0.muscache.com/im/pictures/b79fb3f2-70a2-4fcd-a207-db3124d01e8b.jpg?im_w=1200" class="d-block w-100" alt="">
                    </div>
                    <div class="carousel-item">
                        <img src="" class="d-block w-100" alt="">
                    </div>
                    <div class="carousel-item">
                        <img src="" class="d-block w-100" alt="">
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
</template>


<script>
import { ref } from "vue";
//import axios from "axios";
import Modal from "./Modal";

//let listingId = 1;
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
    }
    // data(){
    //     imageSrc : 'https://a0.muscache.com/im/pictures/36283cf5-95c8-4c70-800f-b1c5a9a6f5a0.jpg?im_w=1200'
    // }//,
    // methods(){
    //     displayImage(item){
    //         return null;
    //     };
    // }
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