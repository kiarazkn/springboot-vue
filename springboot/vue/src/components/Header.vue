<template>
    <div style="line-height:60px;display:flex;">
        <div style="flex: 1; font-size: 20px">
            <span :class="collapseBtnClass" style="cursor: pointer" @click="collapse"></span>

            <el-breadcrumb separator="/" style="display: inline-block; margin-left: 30px">
                <el-breadcrumb-item :to="'/'">首页</el-breadcrumb-item>
                <el-breadcrumb-item>{{currentPathName}}</el-breadcrumb-item>
            </el-breadcrumb>

        </div>

        <el-dropdown style="width:100px; cursor: pointer">
            <i class="el-icon-user" style="font-size: 18px"></i>
            <i class="el-icon-arrow-down" style="margin-left: 5px;"></i>
            <el-dropdown-menu slot="dropdown" style="width: 100px">
                <router-link to="/login" style="text-decoration: none">
                    <el-dropdown-item style="font-size: 14px;padding: 10px;">退出</el-dropdown-item>
                </router-link>
            </el-dropdown-menu>
        </el-dropdown>
    </div>
</template>

<script>
    export default {
        name: "Header",
        props:{
            collapseBtnClass:String,
            collapse:Function,
        },
        computed: {
            currentPathName () {
                return this.$store.state.currentPathName;　　//需要监听的数据
            }
        },
        watch: {
            currentPathName (newVal, oldVal) {
                console.log(newVal)
            }
        }
    }
</script>

<style scoped>

</style>