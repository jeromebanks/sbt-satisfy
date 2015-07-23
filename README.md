sbt-satisfy
-----------

[![Build Status](https://travis-ci.org/jeromebanks/sbt-satisfy.svg?branch=master)](https://travis-ci.org/jeromebanks/sbt-satisfy)

SBT plugin for deploying Satisfaction projects

Include this plugin to deploy your Satisfaction tracks
 to the correct place on HDFS to be scheduled 


To add the sbt-satisfy plugin to your project, 
 perform the following steps 

* Add the following lines to your project/plugins.sbt file 

```
addSbtPlugin("com.tagged.satisfaction" %% "sbt-satisfy" % "0.15") 
```
   
* Import the sbt-satisfy keys in your build.sbt

```
import sbtSatisfy._
import SatisfyKeys._
```


* Define your track name as property in build.sbt

```
trackName := "MyAwesomeTrack"
```

* Set a version number ( as you would normally do) to be the version number of your project, (in the form Major.Minor.Patch )

```
version := "0.1.0"
```

* For uploading to the trackpath, set hdfsURI to the URL of your HDFS name server.

```
hdfsURI := new java.net.URI("hdfs://my-hdfs-namenode:8020")
```

*  (Optional) - If you are a using a non-default track path, (instead of /user/satisfaction/track), you can set it with basePath

```
basePath := "/user/my-name/satisfaction/track"
```

*  When you are ready to upload to the Satisfaction Scheduler,
  run the `upload` command from the sbt prompt.

```
sbt
> upload
```

* This will upload the project into an HDFS directory where Satisfaction 
   expects it to be, under /user/satisfaction/track

```
> hadoop dfs -ls /user/satisfaction/track/MyAwesomeTrack
Found 1 items
drwxr-x--x   - jbanks hadoop          0 2014-06-10 15:20 /user/satisfaction/track/MyAwesomeTrack/version_0.1.0
```

*  Define a Track using the Satisfaction Scala DSL under src/main/scala/ .  

*  If you have resources to be uploaded ( like some awesome Hive scripts ),
     place them under src/main/resources

*  Create a file in the conf/ directoy, named "satisfaction.properties".  This contains any sort of configuration properties
   which need to be specified which aren't the Track definition, ( defined in the Scala DSL ) or a resource file

*   Add a property 'satisfaction.track.class' which is the class name of the Scala DSL Track definition

*  Additional commands

** uploadResource -  Only uploads file resources 

** uploadJars - Only uploads jar dependencies

** cleanUpload - Removes all files for the track on HDFS

** uploadProperties - Only uploads the conf/satisfaction.properties file
