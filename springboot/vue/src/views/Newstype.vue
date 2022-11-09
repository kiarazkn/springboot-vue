<template>
    <div>

        <div style="margin:10px 0">
            <el-input style="width:400px" placeholder="请输入名称" suffix-icon="el-icon-search"
                      v-model="typename"></el-input>
            <el-button class="ml-5" type="primary" @click="load">搜索</el-button>
            <el-button type="warning" @click="reset">重置</el-button>
            <el-button type="primary" @click="handleAdd" style="margin-left: 200px">新增 <i class="el-icon-circle-plus-outline"></i></el-button>
        </div>


        <el-table :data="tableData" border stripe :header-cell-class-name="headerBg">
            <el-table-column type="selection" width="55px"></el-table-column>
            <el-table-column prop="id" label="id"></el-table-column>
            <el-table-column prop="typename" label="新闻类型"></el-table-column>
            <el-table-column label="操作" align="center">
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

        <el-dialog title="新闻类型" :visible.sync="dialogFormVisible" width="30%">
            <el-form label-width="80px" size="small">
                <el-form-item label="新闻类型">
                    <el-input v-model="form.typename" autocomplete="off"></el-input>
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
        name: "Newstype",
        data(){
            return{
                tableData: [],
                total: 0,
                pageNum: 1,
                pageSize: 5,
                typename: "",
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
                this.request.get("/newstype/page", {
                    params: {
                        pageNum: this.pageNum,
                        pageSize: this.pageSize,
                        typename: this.typename,
                    }
                }).then(res => {
                    console.log(res)

                    this.tableData = res.data
                    this.total = res.total
                })
            },
            save() {
                this.request.post("/newstype", this.form).then(res => {
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
                this.request.delete("/newstype/" + id).then(res => {
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
</style>
