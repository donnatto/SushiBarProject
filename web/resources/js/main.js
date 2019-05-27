// JavaScript Document

$(document).ready(function(){
	"use strict";
	$(window).scroll(function(){
		$("nav").toggleClass("scrolled", $(this).scrollTop() > 630);
	});//cambiar de color nav
	
	$(".img-hover").mouseover(function(){
		$(".img-hover img").css("filter", "blur(10px)");
		$(this).find("img").css("filter","blur(0px)");
	});
	$(".img-hover").mouseout(function(){
		$(".img-hover img").css("filter","blur(0px)");
	});//enfocar/desenfocar imagenes carta.
	
	
	
	
	
});