<template>
<div class="contained">
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
             <div >
                 <ul>
                     <li><img :src="firstImage" class="sectioned"></li>
                     <li><img :src="secondImage" class="sectioned"></li>
                     <li><img :src="thirdImage" class="sectioned"></li>
                     <li><img :src="fourthImage" class="sectioned"></li>
                     <li><img :src="fifthImage" class="sectioned"></li>
                 </ul>
             </div>
    </Modal>
</div>
</template>


<script>
import { ref } from "vue";
import axios from "axios";
import Modal from "./Modal";

let listingId = 2;
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
    methods: {

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
    }

    .leftImage{
        object-fit: fill;
        height: 100%;
        width: 100%;
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
        overflow: hidden;
    }
    .carousel-item{
        object-fit: fill;
    }
    .carousel{
        margin: 15px;
        object-fit: cover;
        
    }

    .sectioned{
        width: 95%;
        margin: 10px;
        margin-left: 4%;
    }

    
    

    
</style>