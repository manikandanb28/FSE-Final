<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
        <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Spring5 MVC Hibernate Demo</title>
        <style type="text/css">
            .error {
                color: red;
            }
            table {
                width: 50%;
                border-collapse: collapse;
                border-spacing: 0px;
            }
            table td {
                border: 1px solid #565454;
                padding: 20px;
            }
        </style>

        <script>
            function deleteBook(bookId){
            //alert("BookId:"+bookId);
            document.location.href = "/deleteBook/"+bookId;
                }
            function deleteSubject(subjectId){
                    //alert("SubjectId:"+subjectId);
                    document.location.href = "/deleteSubject/"+subjectId;
                }
        </script>
    </head>
    <body>
        <a href="task" style="float: right;">Task</a>

        <table border="0px">
            <tr>
                <td>
                    <div style="float: left;">
                        <h2>Task Form</h2>
                       <form:form action="addBook" method="post" modelAttribute="tasks">
                                <table>
                                    
                                    <tr>
                                        <td>Task</td>
                                        <td>
                                            <form:input path="task" /> <br />
                                            <form:errors path="task" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Parent Task</td>
                                        <td>
                                            <form:input path="parentTaskValue" /> <br />
                                            <form:errors path="parentTaskValue" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Priorty</td>
                                        <td>
                                            <form:input path="priority" /> <br />
                                            <form:errors path="priority" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Start Date(yyyy-MM-dd)</td>
                                        <td>
                                            <form:input type="date" path="publishDate" /> <br />
                                            <form:errors path="publishDate" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>End Date(yyyy-MM-dd)</td>
                                        <td>
                                            <form:input type="date" path="publishDate" /> <br />
                                            <form:errors path="publishDate" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><button type="submit">Submit</button></td>
                                    </tr>
                                </table>
                            </form:form>
                    </div>
                </td>
                <%-- <td>
                    <div>
                        <h2>Subject List</h2>
                        <table>
                            <tr>
                                <td><strong>Subtitle</strong></td>
                                <td><strong>Duration In Hours</strong></td>
                            </tr>
                            <c:forEach items="${subjects}" var="subject">
                                <tr>
                                    <td>${subject.subtitle}</td>
                                    <td>${subject.durationInHours}</td>
                                    <td><input type="button" value="Delete" onclick="deleteSubject('${subject.subjectId}')"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </td> --%>
            </tr>
           <%--  <tr>
                <td>
                    <div style="float: left">
                        <h2>Book Form</h2>
                            <form:form action="addBook" method="post" modelAttribute="bookDto">
                                <table>
                                    <tr>
                                        <td>Subject</td>
                                        <td>
                                            <form:select path="subjectId" >
                                                <form:option value="NONE" label="select"/>
                                                <form:options items = "${subjectMap}"/>
                                             </form:select><br />
                                            <form:errors path="subjectId" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Title</td>
                                        <td>
                                            <form:input path="title" /> <br />
                                            <form:errors path="title" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Price</td>
                                        <td>
                                            <form:input path="price" /> <br />
                                            <form:errors path="price" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Volume</td>
                                        <td>
                                            <form:input path="volume" /> <br />
                                            <form:errors path="volume" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Publish Date(yyyy-MM-dd)</td>
                                        <td>
                                            <form:input type="date" path="publishDate" /> <br />
                                            <form:errors path="publishDate" cssClass="error" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><button type="submit">Submit</button></td>
                                    </tr>
                                </table>
                            </form:form>
                    </div>
                </td>
                <td>
                    <div style="float: right">
                        <h2>Book List</h2>
                        <table>
                            <tr>
                                <td><strong>Title</strong></td>
                                <td><strong>Price</strong></td>
                                <td><strong>Volume</strong></td>
                                <td><strong>Publish Date</strong></td>
                                <td><strong>Subject</strong></td>
                            </tr>

                            <c:forEach items="${books}" var="book">
                                <tr>
                                    <td>${book.title}</td>
                                    <td>${book.price}</td>
                                    <td>${book.volume}</td>
                                    <td>${book.publishDate}</td>
                                    <td>${book.subject.subtitle}</td>
                                    <td><input type="button" value="Delete" onclick="deleteBook('${book.bookId}')"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </td>
            </tr> --%>
        </table>
        
    </body>
</html>