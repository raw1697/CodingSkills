<?php
class Users_model extends CI_Model {

  public function __construct() {
    ///load database into the model
    $this->load->database();
  }
//a function to get messages from the database by using id, passing throught param
  public function checkLogin($username,$pass){
    //query and using placeholder '?' as we want to pass it through the URL
	  $sql = "SELECT * FROM Users WHERE username = ? AND password = ? "; 
      $query = $this->db->query($sql, array($username,sha1($pass)));
      return $query->result_array();
	  
	  // password checking 
	//    echo 'errlnkjdj';
		  
	//	return true;
        
	//	else{
			
	//	return FALSE;
		
		}
	 
		
	
		
	 }
	
	 


     
	

	
	
	
	
	
		

   







