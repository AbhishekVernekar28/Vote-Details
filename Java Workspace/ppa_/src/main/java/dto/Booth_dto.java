package dto;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Booth_dto {
	@Id
	int Polling_Booth_Number;
	String Polling_Booth_Name;
	String Parent_Constituency;
	String _2014_Winner;
	String _2014_RunnerUp;
	double _2014_Margin_per;
	int _2014_Margin;
	int _2014_Total_votes;
	int _2014_BJP_votes;
	double _2014_BIP_per;
	int _2014_INC_Votes;
	double _2014_INC_per;
	String _2019_Winner;
	double _2019_Margin_per;
	int _2019_Margin;
	int _2019_Total_votes;
	int _2019_BJP_votes;
	double _2019_BIP_per;
	int _2019_INC_Votes;
	double _2019_INC_per;
	boolean isStatus ;
}
