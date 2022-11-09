<template>
    <div class="wrapper">
        <div style="margin:5% auto; background-color: #fff; width: 350px; height: 500px; padding: 20px; border-radius: 10px">
            <div style="margin: 10px 0; text-align: center; font-size: 24px"><b>注 册</b></div>
            <el-form :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="70px"
                     class="demo-ruleForm">
                <el-form-item label="用户名" prop="username">
                    <el-input type="text" size="medium" v-model="ruleForm.username" placeholder="请输入用户名"
                              autocomplete="off" prefix-icon="el-icon-user"></el-input>
                </el-form-item>
                <el-form-item label="昵称" prop="nickname">
                    <el-input type="text" size="medium" v-model="ruleForm.nickname" placeholder="请输入昵称"
                              autocomplete="off" prefix-icon="el-icon-user"></el-input>
                </el-form-item>
                <el-form-item label="邮箱" prop="email">
                    <el-input type="text" size="medium" v-model="ruleForm.email" placeholder="请输入邮箱"
                              autocomplete="off" prefix-icon="el-icon-message"></el-input>
                </el-form-item>
                <el-form-item label="电话" prop="phone">
                    <el-input type="text" size="medium" v-model="ruleForm.phone" placeholder="请输入电话"
                              autocomplete="off" prefix-icon="el-icon-mobile-phone"></el-input>
                </el-form-item>
                <el-form-item label="密码" prop="password">
                    <el-input size="password" type="password" v-model="ruleForm.password" autocomplete="off"
                              placeholder="请输入密码" prefix-icon="el-icon-lock"></el-input>
                </el-form-item>
                <el-form-item label="确认密码" prop="checkPass">
                    <el-input size="medium" type="password" v-model="ruleForm.checkPass" autocomplete="off"
                              placeholder="请再次输入密码" prefix-icon="el-icon-lock"></el-input>
                </el-form-item>

                <el-form-item style="margin-left: 30px">
                    <el-button type="primary" @click="register">提交</el-button>
                    <el-button @click="resetForm('ruleForm')">重置</el-button>
                </el-form-item>
                <el-form-item style="margin-left: 90px;">
                    <router-link :to="{ path: 'login' }">已有账户？去登陆</router-link>
                </el-form-item>
            </el-form>
        </div>
    </div>
</template>

<script>
    export default {
        name: "Register",
        data() {

            var validatePass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm.checkPass !== '') {
                        this.$refs.ruleForm.validateField('checkPass');
                    }
                    callback();
                }
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.password) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            return {
                ruleForm: {
                    username: '',
                    nickname: '',
                    email:'',
                    phone:'',
                    password: '',
                    checkPass: '',
                },
                rules: {
                    username: [
                        {required: true, message: "请输入用户名", trigger: 'blur'},
                        {min: 2, max: 9, message: "长度2到9个字符",trigger: 'blur'}
                    ],
                    nickname: [
                        {required: true, message: "请输入昵称", trigger: 'blur'},
                        {min: 2, max: 9, message: "长度2到9个字符",trigger: 'blur'}
                    ],
                    email: [
                        {required: true, message: "请输入邮箱", trigger: 'blur'},
                        {min: 2, max: 20, message: "长度10到20个字符",trigger: 'blur'}
                    ],
                    phone: [
                        {required: true, message: "请输入电话", trigger: 'blur'},
                        {min: 11, max: 13, message: "电话号为11个字符",trigger: 'blur'}
                    ],
                    password: [
                        {validator: validatePass, trigger: 'blur'}
                    ],
                    checkPass: [
                        {validator: validatePass2, trigger: 'blur'}
                    ]
                }
            };
        },
        methods: {
            register() {
                this.$refs['ruleForm'].validate((valid) => {
                    if (valid) {  // 表单校验合法
                        this.request.post("/user", this.ruleForm).then(res => {
                            if(!res) {
                                this.$message.error("注册失败")
                            } else {
                                this.$router.push("/login")
                            }
                        })
                    } else {
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },


        }
    }
</script>


<style>
    .wrapper {
        height: 100vh;
        background-image: linear-gradient(125deg, #30cfd0 0%, #330867 100%);
        overflow: hidden;
    }
</style>