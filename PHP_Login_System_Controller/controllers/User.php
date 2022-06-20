<?php
defined('BASEPATH') OR exit('No direct script access allowed');

class User extends CI_Controller {

	/**
	 * Index Page for this controller.
	 *
	 * Maps to the following URL
	 * 		http://example.com/index.php/welcome
	 *	- or -
	 * 		http://example.com/index.php/welcome/index
	 *	- or -
	 * Since this controller is set as the default controller in
	 * config/routes.php, it's displayed at http://example.com/
	 *
	 * So any other public methods not prefixed with an underscore will
	 * map to /index.php/welcome/<method_name>
	 * @see https://codeigniter.com/user_guide/general/urls.html
	 */
	public function index(){echo "Hello world is so boringgg! 16th reflect mother";}
	

	// controller and view task below.
    //raptor.kent.ac.uk/~ra466/ci/index.php/User/show/idHere/nameHere
	// new show method that give two parameters below "idHere and nameHere" and the conditions for them.
	public function view($name = null){
	if($name == null){
		echo "error message";
	}
	else {
		//echo "Hello daddy<br>";
		//echo "Hello";
	  $this->load->model('Messages_model');
	  $data = $this->Messages_model->getMessagesByPoster($name);
	 
	  $data = array("results" => $data);
      $this->load->view('ViewMessages', $data);
	}
	}
	
	//public function view(){
	
	//}
	
	
	
	//// part II
	public function login(){
		
		
	$this->load->view('Login');
	//$this->load->view('Login');	
	}

	
	public function doLogin(){
		
	$username = $this->input->post('username');	
	$pass = $this->input->post('password');	
	$this->load->model('Users_model');
	$data = $this->Users_model->checkLogin($username, $pass);
    //$data['row'] = $this->Messages_model->getMessagesByPoster($username);
	//$this->load->view('ViewMessages', $data);
	if ($data)
	{
		session_start();
		$_SESSION['username'] = $username;
		redirect(site_url('user/view/' . $username));
		
	}
	else 
	{
		echo "incorrect load details please try again";
		$this->load->view('Login');
    }
	
	}
	
	public function logout(){
	
		
		//session_start();
		session_destroy();
		//header('Location: login.php');
		//$this->load->view('Login');
		redirect(site_url('user/login'));
		
		}
		
		public function doPost(){
			
			
			
		} 
    }
	
		
		

	
