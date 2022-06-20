<?php
class Messages_model extends CI_Model {

  public function __construct() {
    ///loads up the database in the model
    $this->load->database();
  }
  
  //a function to get messages from the database by using id, passing throught param
  public function getMessagesByPoster($name) {
    //query and using placeholder '?' as we want to pass it through the URL
    $sql = 'SELECT * FROM Messages WHERE user_username = ? ORDER BY posted_at DESC'; 
    $query = $this->db->query($sql, array($name));
    return $query->result_array();
    }
	
	public function searchMessages($string) {
    //query and using placeholder '?' as we want to pass it through the URL
    
    $query = $this->db->query("SELECT * FROM Messages WHERE text LIKE '%$string%'");
    return $query->result_array();
	
	//public function insertMessage($poster, $string){
		
	//}
	
	//public function insertMessage($poster, $string){	
		
	//}
	
    }


	}







