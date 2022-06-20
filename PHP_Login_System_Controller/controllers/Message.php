<?php 
defined('BASEPATH') OR exit('No direct script access allowed');
class Message extends CI_Controller {
	
	
	public function index(){
		
	}
	
	public function doPost(){
		
		
		
		$this->session->userdata('logged_in')
 		$poster = $this->session->userdata('logged_in');
 		$string = $this->load->post('post');
 	    $this->Messages_model->insertMessages($poster, $string);
 		redirect(site_url('user/view/' . $username ));
	}
}