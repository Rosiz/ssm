<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<jsp:include page="top.jsp"/>
<jsp:include page="left.jsp"/>
<div class="content-wrapper">
    <section class="content-header">
        <h1>
            添加产品 <small>产品表单</small>
        </h1>
        <ol class="breadcrumb">
            <li><a href="${pageContext.request.contextPath}/index.jsp"><i
                    class="fa fa-dashboard"></i> 首页</a></li>
            <li><a
                    href="${pageContext.request.contextPath}/product/findAll.do">产品管理</a></li>
            <li class="active">产品表单</li>
        </ol>
    </section>
    <!-- 内容头部 /-->

    <form action="/product/save" method="post">
        <!-- 正文区域 -->
        <section class="content"> <!--产品信息-->

            <div class="panel panel-default">
                <div class="panel-heading">产品信息</div>
                <div class="row data-type">

                    <div class="col-md-2 title">产品编号</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" name="productNum"
                               placeholder="产品编号" value="">
                    </div>
                    <div class="col-md-2 title">产品名称</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" name="productName"
                               placeholder="产品名称" value="">
                    </div>
                    <div class="col-md-2 title">出发时间</div>
                    <div class="col-md-4 data">
                        <div class="input-group date">
                            <div class="input-group-addon">
                                <i class="fa fa-calendar"></i>
                            </div>
                            <input type="text" class="form-control pull-right"
                                   id="datepicker-a3" name="departureTime">
                        </div>
                    </div>


                    <div class="col-md-2 title">出发城市</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" name="cityName"
                               placeholder="出发城市" value="">
                    </div>

                    <div class="col-md-2 title">产品价格</div>
                    <div class="col-md-4 data">
                        <input type="text" class="form-control" placeholder="产品价格"
                               name="productPrice" value="">
                    </div>

                    <div class="col-md-2 title">产品状态</div>
                    <div class="col-md-4 data">
                        <select class="form-control select2" style="width: 100%"
                                name="productStatus">
                            <option value="0" selected="selected">关闭</option>
                            <option value="1">开启</option>
                        </select>
                    </div>

                    <div class="col-md-2 title rowHeight2x">其他信息</div>
                    <div class="col-md-10 data rowHeight2x">
							<textarea class="form-control" rows="3" placeholder="其他信息"
                                      name="productDesc"></textarea>
                    </div>

                </div>
            </div>
            <!--订单信息/--> <!--工具栏-->
            <div class="box-tools text-center">
                <button type="submit" class="btn bg-maroon">保存</button>
                <button type="button" class="btn bg-default"
                        onclick="history.back(-1);">返回
                </button>
            </div>
            <!--工具栏/--> </section>
        <!-- 正文区域 /-->
    </form>
</div>
<jsp:include page="bottom.jsp"/>


