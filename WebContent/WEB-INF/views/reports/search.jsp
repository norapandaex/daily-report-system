<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:import url="/WEB-INF/views/layout/app.jsp">
    <c:param name="content">
        <c:if test="${flush != null}">
            <div id="flush_error">
                <c:out value="${flush}"></c:out>
            </div>
        </c:if>
        <h2>検索結果 一覧</h2>
        <div id="search_items">
            検索項目&nbsp;&nbsp;
            <c:if test="${search_name != ''}">
                名前:&nbsp;<c:out value="${search_name}" />&nbsp;&nbsp;
            </c:if>
            <c:if test="${skeyword != ''}">
                キーワード:&nbsp;<c:out value="${skeyword}" />&nbsp;&nbsp;
            </c:if>
            <c:if test="${search_adate != '' || search_bdate != ''}">
                日付:&nbsp;
            </c:if>
            <c:if test="${search_adate != ''}">
                <c:out value="${search_adate}" />&nbsp;以降&nbsp;&nbsp;
            </c:if>
            <c:if test="${search_bdate != ''}">
                <c:out value="${search_bdate}" />&nbsp;以前
            </c:if>
        </div><br />
        <form method="POST" action="<c:url value='/reports/search' />">
            <label for="search_name">名前</label>&nbsp;
            <input type="text" name="search_name" />

            <label for="search_keyword">キーワード</label>&nbsp;
            <input type="text" name="search_keyword" />&nbsp;

            <label for="report_date">日付</label>&nbsp;
            <input type="date" name="search_adate" />
            〜
            <input type="date" name="search_bdate" />

            <button type="submit">検索</button>
        </form>
        <c:choose>
            <c:when test="${searches != null}">
                <table id="report_list">
                    <tbody>
                        <tr>
                            <th class="report_name">氏名</th>
                            <th class="report_date">日付</th>
                            <th class="report_title">タイトル</th>
                            <th class="report_action">操作</th>
                        </tr>
                        <c:forEach var="report" items="${searches}" varStatus="status">
                            <tr class="row${status.count % 2}">
                                <td class="report_name"><c:out value="${report.employee.name}" /></td>
                                <td class="report_date"><fmt:formatDate value='${report.report_date}' pattern='yyyy-MM-dd'/></td>
                                <td class="report_title">${report.title}</td>
                                <td class="report_action"><a href="<c:url value='/reports/show?id=${report.id}' />">詳細を見る</a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:when>
        </c:choose>
        <div id="pagination">
            (全 ${reports_count} 件)<br />
            <c:forEach var="i" begin="1" end="${((reports_count -1) / 15) + 1}"
                step="1">
                <c:choose>
                    <c:when test="${i == page}">
                        <c:out value="${i}" />&nbsp;
                    </c:when>
                    <c:otherwise>
                        <a href="<c:url value='/reports/search?page=${i}' />"><c:out value="${i}" /></a>&nbsp;
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </div>

        <p><a href="<c:url value='/reports/new' />">新規日報の登録</a></p>
        <p><a href="<c:url value='/reports/index' />">一覧に戻る</a></p>

    </c:param>
</c:import>