/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.spicstome.client.services;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;
import com.spicstome.client.dto.AlbumDTO;
import com.spicstome.client.dto.LogDTO;
import com.spicstome.client.dto.MailListDTO;
import com.spicstome.client.dto.Point2D;
import com.spicstome.client.dto.WordDTO;
import com.spicstome.client.dto.FolderDTO;
import com.spicstome.client.dto.ImageDTO;
import com.spicstome.client.dto.ReferentDTO;
import com.spicstome.client.dto.StudentDTO;
import com.spicstome.client.dto.TeacherDTO;
import com.spicstome.client.dto.UserDTO;


public interface SpicsToMeServicesAsync {
	
	/* SESSION */
	void getUser(String userName, String password, AsyncCallback<UserDTO> callback);
	void getCurrentUser(AsyncCallback<UserDTO> callback);
	void disconnectCurrentUser(AsyncCallback<Boolean> callback);
	
	/* GET */
	void getAlbumOwner(long id,AsyncCallback<StudentDTO> callback);
	void getAlbum(long id,AsyncCallback<AlbumDTO> callback);
	void getFolder(long id,AsyncCallback<FolderDTO> callback);
	void getUser(Long idUser, AsyncCallback<UserDTO> callback);
	void getUser(String mail, AsyncCallback<UserDTO> callback);
	void getStudent(Long idStudent, AsyncCallback<StudentDTO> callback); 
	void getReferentConnected(AsyncCallback<ReferentDTO> callback); 
	void getGeneralAndExampleAlbum(AsyncCallback<List<AlbumDTO>> callback);
	void getUserByLogin(String login, AsyncCallback<UserDTO> callback); 
	void getAllStudents(AsyncCallback<List<StudentDTO>> callback);
	void getAllTeachers(AsyncCallback<List<TeacherDTO>> callback);
	void getAllReferents(AsyncCallback<List<ReferentDTO>> callback);
	void getEverybody(AsyncCallback<List<UserDTO>> callback);
	void getAverageMessageLength(int nW,int nY,ArrayList<LogDTO> set,AsyncCallback<Double> callback);
	void getAverageTimeExecution(int nW,int nY,ArrayList<LogDTO> set,AsyncCallback<Double> callback);
	void getHistoryPerWeek(ArrayList<LogDTO> set,int type,AsyncCallback<ArrayList<Point2D>> callback);
	void getPartitionMessageLength(ArrayList<LogDTO> set,AsyncCallback<ArrayList<Double>> callback);
	
	/* SAVE */
	void saveImage(ImageDTO imageDTO, AsyncCallback<Long> callback);
	void saveFolder(FolderDTO folderDTO, AsyncCallback<Long> callback);
	void saveAlbum(AlbumDTO albumDTO, AsyncCallback<Long> callback);
	void saveWord(WordDTO articleDTO, AsyncCallback<Long> callback);
	void saveUser(UserDTO userDTO, AsyncCallback<Long> callback);
	void saveLog(LogDTO logDTO, AsyncCallback<Long> callback);
	
	/* UPDATE */
	void updateFolder(FolderDTO folderDTO,AsyncCallback<Boolean> callack);
	void updateWord(WordDTO articleDTO,AsyncCallback<Boolean> callack);
	void updateImage(ImageDTO imageDTO, AsyncCallback<Long> callback);
	void updateUser(UserDTO userDTO, boolean isNewPassword, AsyncCallback<Long> callback);
	void updateAlbum(AlbumDTO album,AsyncCallback<Boolean> callback);
	void updateFolderAndChild(FolderDTO folder,AsyncCallback<Boolean> callback);

	/* DELETE */	
	void deleteWord(long id,AsyncCallback<Boolean> callback);
	void deleteFolder(long id,AsyncCallback<Boolean> callback);
	void deleteUser(long id,AsyncCallback<Boolean> callback);
	
	/* COPY */
	void copyFolder(FolderDTO folderDTO,FolderDTO parent,AsyncCallback<FolderDTO> callback);
	void copyWord(WordDTO wordDTO,FolderDTO parent,AsyncCallback<WordDTO> callback);
	void copyAlbum(AlbumDTO albumDTO,AsyncCallback<AlbumDTO> callback);
	
	/* MAIL */
	void sendMail(UserDTO sender, String emailReceiver, ArrayList<WordDTO> words, ArrayList<String> correctedWords, AsyncCallback<Boolean> callback);
	void getMails(UserDTO user, int startPosition, boolean isDescDirection, int maxNbValidMails, AsyncCallback<MailListDTO> callback);
}
