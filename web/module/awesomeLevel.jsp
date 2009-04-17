<%@ include file="/WEB-INF/template/include.jsp"%>

<%@ include file="/WEB-INF/template/header.jsp"%>

<!-- There is no "action" on this form, so it posts back to the same url.  This is needed so that spring picks up and uses the same
controller.  When spring sees a "post", it calls the onSubmit methods on the controller -->
<form method="post">

  <!-- The "levelFormBackingObject" bind path is determined by the commandName for the controller.  See the "level" id bean 
  in the /module/applicationContet.xml file  -->

  <!-- The "level" path is determined from the attribute on object.  The object is an org.openrms.module.simpleservice.AwesomeLevel.java object.  
  That object has a "getLevel" and "setLevel" attribute that spring reads in this spring bind tag -->

  <spring:bind path="levelFormBackingObject.level">
    How awesome is this example?! <input type="text" name="${status.expression}" value="${status.value}" /> 
    <c:if test="${status.errorMessage != ''}"><br/><span class="error">${status.errorMessage}</span></c:if>
  </spring:bind>
  <br/>
  <input type="submit" value="Submit"/>
</form>

<br/><br/>
This page is accessed at "localhost:8080/openmrs/module/simpleservice/awesomeLevel.htm" because we set 
it to that in the /metadata/moduleApplicationContext.xml file in the awesomeExampleMapping element.

<%@ include file="/WEB-INF/template/footer.jsp"%>