#ifndef _PLANNING_ICE
#define _PLANNING_ICE

#include <topograph.ice>
#include <cast/slice/CDL.ice>

module eu {
	module nifti {
		module Planning {
			module slice {
			
			enum ActionMode {START, END, WAIT};
			enum Brake {ON, OFF};
			enum State {COMPLETED, FAILED, PENDING, CONFIRMED, ABORTED, ADDED, DELETED, EXECUTED, REQUESTED, NEW, EXECUTING, REJECTED};
			enum Motion {MOVEFORWARD, MOVELEFT, MOVERIGHT, MOVEBACK, TURNLEFT, TURNRIGHT};

    			class Task
    			{
		            /*
		             * This data structure represents the Goal that the                  
		             * planning engine should receive as input.
		             * This class can be a generalization of the                          
		             * different task request coming from different                          
		             * subarchitectures. For this purpose this class                          
		             * should be extended.
		            */
		            string id;
		            string userIntention;
		            State status;
    			};
    			
    			class NavTask extends Task
    			{
    				eu::nifti::env::topograph::Node node;
    			};
    			
    			class VantagePointTask extends Task
    			{   
    			    cast::cdl::WorkingMemoryAddress carWMA;
    			};
    			
    			class MoveBaseTask extends Task
    			{
    				Motion command;
    			};
    			
    			class GUITask extends Task
    			{	
    				double x;
    				double y;
    			};
    			
    			class TopoGraphTask extends Task
    			{
    			    string name;
    			};
    			
    			class DetectGapTraversableTask extends Task
    			{
    			    string name;
    			};
    			
    			class TraverseGapTask extends Task
    			{
    			    string name;
    			};
    			
    			class GoHomeTask extends Task
    			{
    			    string name;
    			};
    
				class Action
				{
					string name;
					string component;
					double time;
					State status;
					/*
					* status = {EXECUTED, ABORTED, PENDING}
					*/
				};
				
				
				class CheckBatteryAction extends Action
				{
				    ActionMode op;
				};
				
				class CheckWifiAction extends Action
				{
				    ActionMode op;
				};
				
				class GoToNodeAction extends Action
				{
					eu::nifti::env::topograph::Node node;
					double theta;
				};
				
				class TopoGraphWriterAction extends Action
				{
				    ActionMode op;
				};
				
				class TogoGraphBuilderAction extends Action
				{
				    ActionMode op;
				};
				
				class FunctionalMappingAction extends Action
				{
				    ActionMode op;
				};
				/*
				* alfa1 = front left
				* alfa2 = front right
				* alfa3 = rear right
				* alfa4 = rear left
				*/
				class FlipperAction extends Action
				{
				    double alfa;
				};
				
				class DifferentialAction extends Action
				{
				    Brake flag;
				};
				
				class RotatingLaserAction extends Action
				{
				    double speed;
				};
				
				class CenterLaserAction extends Action
				{
				};
				
				class GapDetectionAction extends Action
				{
				    ActionMode op;
				};
				
				class FailurePlanAction extends Action
				{
				};
				
				class MoveBaseAction extends Action
				{
				    Motion command;
				};
				
				class ChangeArmHeight extends Action
				{
					int height; 
				};
				
				class AutoModeAction extends Action
				{
				};
				
				/*
				* A timeline is a sequence of acions performed
				* by robot component
				*/
				sequence<Action> ActionSeq;
    
				class Timeline
				{
					string component;
					ActionSeq actions;
				};
				
				/*
				* in order to accomodate concurrenty and flexibility
				* we specify a sequence of timelines
				*/
				sequence<Timeline> TimelineSeq;
				
				class Plan
				{
					string id;
					Task goal;
					TimelineSeq bag; 
					/* bag of timelines generated by the planning engine */
					TimelineSeq executedBag; /* bag of timelines already executed */
					TimelineSeq remainingBag; /* bag of timelines not till executed */
					State status;
					/* status = {EXECUTED, ABORTED, PENDING} */
				};
			};
		};
	};
};


#endif

