<#import "/spring.ftl" as spring/>
<head>
    <#include "../layout/bootstrap.ftl">
</head>
<body>
    <H1>Product Create</H1>
    <a href="index">Product List</a>
    <br>

    <form action="<@spring.url '/product/create'/>" method="POST">
    	<div class="form-group">
    		<label for="name">Name</label>
	        <input type="text" id="name" class="form-control" name="name" value="">
        </div>
        <div class="form-group">
	        <label for="price">Price</label>
	        <input type="text" id="price" class="form-control" name="price" value="">
		</div>
        <input type="submit" value="Submit">
    </form>
</body>