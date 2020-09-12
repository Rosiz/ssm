<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="top.jsp" />
<jsp:include page="left.jsp" />
<div class="content-wrapper">

    <!-- 内容头部 -->
    <section class="content-header">
        <h1>
            订单管理
            <small>订单列表</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> 首页</a></li>
            <li><a href="#">数据管理</a></li>
            <li class="active">数据列表</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <!-- 正文区域 -->
    <section class="content">

        <!-- .box-body -->
        <div class="box box-primary">
            <div class="box-header with-border">
                <h3 class="box-title">列表</h3>
            </div>

            <div class="box-body">

                <!-- 数据表格 -->
                <div class="table-box">

                    <!--工具栏-->
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" title="新建"><i class="fa fa-file-o"></i> <a href="/product/toSave">新建</a></button>
                                <button type="button" class="btn btn-default" title="删除"><i class="fa fa-trash-o"></i> 删除</button>
                                <button type="button" class="btn btn-default" title="开启"><i class="fa fa-check"></i> 开启</button>
                                <button type="button" class="btn btn-default" title="屏蔽"><i class="fa fa-ban"></i> 屏蔽</button>
                                <button type="button" class="btn btn-default" title="刷新"><i class="fa fa-refresh"></i> 刷新</button>
                            </div>
                        </div>
                    </div>
                    <div class="box-tools pull-right">
                        <div class="has-feedback">
                            <input type="text" class="form-control input-sm" placeholder="搜索">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </div>
                    <!--工具栏/-->

                    <!--数据列表-->
                    <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                        <thead>
                        <tr>
                            <th class="" style="padding-right:0px;">
                                <input id="selall" type="checkbox" class="icheckbox_square-blue">
                            </th>
                            <th class="sorting_asc">ID</th>
                            <th class="sorting_desc">订单编号</th>
                            <th class="sorting_asc sorting_asc_disabled">产品名称</th>
                            <th class="sorting_desc sorting_desc_disabled">金额</th>
                            <th class="sorting">下单时间</th>
                            <th class="text-center sorting">订单状态</th>
                            <th class="text-center">操作</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${orders.list}" var="ord">
                        <tr>
                            <td><input name="ids" type="checkbox"></td>
                            <td>${ord.id}</td>
                            <td>${ord.orderNum}</td>
                            <td>${ord.product.productName}</td>
                            <td>${ord.product.productPrice}</td>
                            <td>${ord.orderTimeStr}</td>
                            <td class="text-center">${ord.orderStatusStr}</td>
                            <td class="text-center">
                                <button type="button" class="btn bg-olive btn-xs"><a style="color:#ffffff" href="/orders/findById?id=${ord.id}">详情</a></button>
                                <button type="button" class="btn bg-purple btn-xs">编辑</button>
                                <button type="button" class="btn bg-maroon btn-xs">删除</button>
                            </td>
                        </tr>
                        </c:forEach>
                        </tbody>
                        <!--
                    <tfoot>
                    <tr>
                    <th>Rendering engine</th>
                    <th>Browser</th>
                    <th>Platform(s)</th>
                    <th>Engine version</th>
                    <th>CSS grade</th>
                    </tr>
                    </tfoot>-->
                    </table>
                    <!--数据列表/-->

                    <!--工具栏-->
                    <div class="pull-left">
                        <div class="form-group form-inline">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default" title="新建"><i class="fa fa-file-o"></i> 新建</button>
                                <button type="button" class="btn btn-default" title="删除"><i class="fa fa-trash-o"></i> 删除</button>
                                <button type="button" class="btn btn-default" title="开启"><i class="fa fa-check"></i> 开启</button>
                                <button type="button" class="btn btn-default" title="屏蔽"><i class="fa fa-ban"></i> 屏蔽</button>
                                <button type="button" class="btn btn-default" title="刷新"><i class="fa fa-refresh"></i> 刷新</button>
                            </div>
                        </div>
                    </div>
                    <div class="box-tools pull-right">
                        <div class="has-feedback">
                            <input type="text" class="form-control input-sm" placeholder="搜索">
                            <span class="glyphicon glyphicon-search form-control-feedback"></span>
                        </div>
                    </div>
                    <!--工具栏/-->

                </div>
                <!-- 数据表格 /-->


            </div>
            <!-- /.box-body -->

            <!-- .box-footer-->
            <div class="box-footer">
                <div class="pull-left">
                    <div class="form-group form-inline">
                        总共${orders.pages} 页，共${orders.total} 条数据。 每页
                        <select class="form-control" id="changePageSize" onchange="changePageSize()">
                            <option>1</option>
                            <option>2</option>
                            <option>3</option>
                            <option>4</option>
                            <option>5</option>
                        </select> 条
                    </div>
                </div>

                <div class="box-tools pull-right">
                    <ul class="pagination">
                        <li>
                            <a href="/orders/findAll?page=1&size=${orders.pageSize}" aria-label="Previous">首页</a>
                        </li>
                        <li><a href="/orders/findAll?page=${orders.pageNum-1}&size=${orders.pageSize}">上一页</a></li>
                        <c:forEach begin="1" end="${orders.pages}" var="pageNum">
                            <li><a href="/orders/findAll?page=${pageNum}&size=${orders.pageSize}">${pageNum}</a></li>
                        </c:forEach>
                        <li><a href="/orders/findAll?page=${orders.pageNum+1}&size=${orders.pageSize}">下一页</a></li>
                        <li>
                            <a href="/orders/findAll?page=${orders.pages}&size=${orders.pageSize}" aria-label="Next">尾页</a>
                        </li>
                    </ul>
                </div>

            </div>
            <!-- /.box-footer-->



        </div>

    </section>
    <!-- 正文区域 /-->

</div>
<jsp:include page="bottom.jsp" />
