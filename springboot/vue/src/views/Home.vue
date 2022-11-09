<template>
    <el-card>
        <el-carousel :interval="2000" type="card" height="300px">
            <el-carousel-item v-for="item in imgList" :key="item">
                <img :src="item.img" style="height:100%;width:100%;">
            </el-carousel-item>
        </el-carousel>
        <div style="margin: 20px 70px">
            <span style="font-size: 40px;">欢迎您！</span>
            <el-divider></el-divider>
            <span>今天的新闻就是明天的历史</span>
        </div>

    </el-card>



</template>

<script>
    export default {
        name: "Home",
        data(){
            return{
                imgList: [
                    {img: require('../assets/1.jpg')},
                    {img: require('../assets/2.jpg')},
                    {img: require('../assets/3.jpg')},
                    {img: require('../assets/4.jpg')},
                ],
            }
        }

    }
</script>

<style>
    /*.el-carousel__item img {*/
        /*color: #475669;*/
        /*font-size: 14px;*/
        /*opacity: 0.75;*/
        /*line-height: 200px;*/
        /*margin: 0;*/
    /*}*/
    .el-carousel__item:nth-child(2n) {
        background-color: #99a9bf;
    }
    .el-carousel__item:nth-child(2n+1) {
        background-color: #d3dce6;
    }
</style>