<template>
    <el-menu :default-openeds="['1', '3']" style="min-height:100%;overflow-x:hidden"
             background-color="#0a2a43"
             text-color="#fff"
             active-text-color="#ffd04b"
             :collapse-transition="false"
             :collapse="isCollapse"
             router
    >
        <div style="height: 60px; line-height: 60px; text-align: center">
            <img src="../assets/logo.png" alt=""
                 style="width: 20px; position: relative; top: 5px; margin-right: 5px">
            <b style="color: white" v-show="logoTextShow">新闻管理系统</b>
        </div>



        <el-menu-item index="/">
            <template>
                <i class="el-icon-s-home"></i>
                <span slot="title">主页</span>
            </template>
        </el-menu-item>

        <el-submenu index="2">
            <template slot="title">
                <i class="el-icon-menu"></i>
                <span slot="title">系统管理</span>
            </template>
                <el-menu-item index="/user">
                    <i class="el-icon-s-custom"></i>
                    <span slot="title">用户管理</span>
                </el-menu-item>
            <el-menu-item index="/newstype">
                <i class="el-icon-s-management"></i>
                <span slot="title">新闻类别</span>
            </el-menu-item>
            <el-menu-item index="/news">
                <i class="el-icon-s-flag"></i>
                <span slot="title">新闻管理</span>
            </el-menu-item>
        </el-submenu>

    </el-menu>
</template>

<script>
    export default {
        name: "Aside",
        props: {
            isCollapse: Boolean,
            logoTextShow:Boolean
        }
    }
</script>

<style scoped>

</style>