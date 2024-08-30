console.log("This is script ");
const toggleSidebar = () => {
	if($('.sidebar').is(":visible"))
	{
		//true ->off korna ha
		$(".sidebar").css("display","none");
		$(".content").css("margin-left","0%");
	}else
	{
		//false ->show karna ha
		$(".sidebar").css("display","block");
		$(".content").css("margin-left","20%");
	}
};

const search=()=>{
	console.log("Searching");
	let query = $("#search-input").val();
	if(query=='')
	{
		$(".search-result").hide();
	}
	else
	{
		//search:
		//console.log(query);
		//send requst to backend:
		let url = `http://localhost:8083/search/${query}`;
		fetch(url).then((response) => {
			return response.json();
		}).then((data) => {
			//data access:
			console.log(data);
			let text=`<div class='list-group'>`
			
			data.forEach((contact) => {
				text+=`<a href='/user/${contact.cId}/contact' class='list-group-item list-group-item-action'>${contact.name}</a>`
			});
			
			text+=`</div>`;
			$(".search-result").html(text);
			$(".search-result").show();
		});
		
		
	}
};