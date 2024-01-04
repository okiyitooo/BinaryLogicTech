<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Pooping in Heaven</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
</head>
<body>
  <div class="container">
    <h1 class="text-center">Pooping in Heaven</h1>
    <form class="form-horizontal" action="processForm2">
        <label for="location" class="form-label">Where would you like to poop in heaven?</label>
        <select class="form-select" id="location" name ="pooper">
          <option value="On the clouds">On the clouds</option>
          <option value="On a rainbow">On a rainbow</option>
          <option value="On a golden throne">On a golden throne</option>
          <option value="In the ocean">In the ocean</option>
          <option value="In a galaxy">In a galaxy</option>
          </select>
      <button  id="submitButton" class="btn btn-primary">Submit</button>
    </form>
  </div>

  <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
