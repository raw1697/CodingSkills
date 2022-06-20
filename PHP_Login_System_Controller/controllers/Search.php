<?php

defined('BASEPATH') OR exit('No direct script access allowed');

class Search extends CI_Controller {


	public function index(){
	$this->load->view('Search'); 
	
	}	

	

     public function dosearch(){
	  
      if (!(isset($_GET['text']))) {
	  
	  }
	  else{
	  $string = $_GET['text'];
      $this->load->model('Messages_model');
	  $data['results'] = $this->Messages_model->searchMessages($string);
	  $this->load->view('ViewMessages',$data);
	//  print_r($data['messages']);
	  }
	  
}
	
	
}

