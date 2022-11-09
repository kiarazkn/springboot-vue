<template>
    <div>

        <div style="margin:10px 0">
            <el-input style="width:400px" placeholder="请输入标题" suffix-icon="el-icon-search"
                      v-model="title"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
            <el-button type="primary" @click="handleAdd" style="margin-left: 200px">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
        </div>


        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
            <el-table-column type="selection" width="50"></el-table-column>
            <el-table-column prop="id" label="id" width="50"></el-table-column>
            <el-table-column  label="详情" type="expand">
                <template slot-scope="props">
                    <el-form label-position="left" inline class="demo-table-expand">
                        <el-form-item label="标题：">
                            <span>{{ props.row.title }}</span>
                        </el-form-item>
                        <el-form-item label="内容：">
                            <span>{{ props.row.content }}</span>
                        </el-form-item>
                        <el-form-item label="来源：">
                            <span>{{ props.row.comefrom }}</span>
                        </el-form-item>
                        <el-form-item label="发表日期：">
                            <span>{{ props.row.publishdate }}</span>
                        </el-form-item>
                    </el-form>
                </template>
            </el-table-column>
            <el-table-column prop="title" label="标题"></el-table-column>
            <el-table-column prop="publishdate" label="发布日期" width="180"></el-table-column>

            <el-table-column label="操作" align="center" width="180">
                <template slot-scope="scope">
                    <el-button type="success" @click="handleEdit(scope.row)">编辑 <i class="el-icon-edit"></i>
                    </el-button>
                    <el-popconfirm
                            class="ml-5"
                            confirm-button-text='确定'
                            cancel-button-text='我再想想'
                            icon="el-icon-info"
                            icon-color="red"
                            title="您确定删除吗？"
                            @confirm="del(scope.row.id)">
                        <el-button type="danger" slot="reference">删除 <i class="el-icon-remove-outline"></i>
                        </el-button>
                    </el-popconfirm>
                </template>
            </el-table-column>
        </el-table>

        <div style="padding:10px 0">
            <el-pagination
                    @size-change="handleSizeChange"
                    @current-change="handleCurrentChange"
                    :current-page="pageNum"
                    :page-sizes="[2, 5, 10]"
                    :page-size="pageSize"
                    layout="total, sizes, prev, pager, next, jumper"
                    :total="total">
            </el-pagination>
        </div>

        <el-dialog title="编辑新闻" :visible.sync="dialogFormVisible"  width="70%">
            <el-form label-width="80px" size="small">
                <el-form-item label="标题">
                    <el-input v-model="form.title" autocomplete="off"></el-input>
                    <!--<el-select style="margin-top: 20px" v-model="form.region" placeholder="请选择新闻类型">-->
                        <!--<option value="">&#45;&#45;选择新闻类型&#45;&#45;</option>-->
                        <!--<el-option v-for="item in typeList" :key="item.typeid" :label="item.typename" :value="news.typeid" ></el-option>-->
                    <!--</el-select>-->
                </el-form-item>

                <el-form-item label="内容">
                    <el-input type="textarea" v-model="form.content" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item label="来源">
                    <el-input v-model="form.comefrom" autocomplete="off"></el-input>
                </el-form-item>
            </el-form>
            <div slot="footer" class="dialog-footer">
                <el-button @click="dialogFormVisible = false">取 消</el-button>
                <el-button type="primary" @click="save">确 定</el-button>
            </div>
        </el-dialog>
    </div>
</template>

<script>
    export default {
        name: "News",
        data(){
            return{
                tableData: [],
                typeList:[],
                total: 0,
                pageNum: 1,
                pageSize: 5,
                title: "",
                content:"",
                typeid:"",
                publishdate:"",
                comefrom:"",
                form: {},
                dialogFormVisible: false,
                multipleSelection: [],
                headerBg: 'headerBg',
            }
        },
        created() {
            // 请求分页查询数据
            this.load()
        },
        methods:{
            load() {
                this.request.get("/news/page", {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        title: this.title,
                        typeid:this.typeid,
                        content:this.content,
                        publishdate:this.publishdate,
                        comefrom:this.comefrom
                    }
                }).then(res => {
                    console.log(res)
                    this.tableData = res.data
                    this.total = res.total
                })
            },
            save() {
                this.request.post("/news", this.form).then(res => {
                    if (res) {
                        this.$message.success("保存成功")
                        this.dialogFormVisible = false
                        this.load()
                    } else {
                        this.$message.error("保存失败")
                    }
                })
            },
            handleAdd() {
                this.dialogFormVisible = true
                this.form = {}
            },
            handleEdit(row) {
                this.form = row
                this.dialogFormVisible = true
            },
            del(id) {
                this.request.delete("/news/" + id).then(res => {
                    if (res) {
                        this.$message.success("删除成功")
                        this.load()
                    } else {
                        this.$message.error("删除失败")
                    }
                })
            },
            reset() {
                this.typename = ""
                this.load()
            },
            handleSizeChange(pageSize) {
                console.log(pageSize)
                this.pageSize = pageSize
                this.load()
            },
            handleCurrentChange(pageNum) {
                console.log(pageNum)
                this.pageNum = pageNum
                this.load()
            },


        }
    }
</script>

<style>
    .headerBg {
        background: #eee !important;
    }
    .el-textarea__inner{
        height: 160px;
        overflow-y: auto;
        /* overflow-y: auto;兼容ie  */
    }
</style>
