## An android project to learn about Jetpack Compose 

### References
1. Video URL: [Jetpack Compose Series](https://www.youtube.com/playlist?list=PLHRvASjG6y05T7jdDC4YTwhTAT28rbYI1)

### Some images about this project


### Composable and special function
1. **stringResource(int id)**: 
- Nhận id (int) làm tham số đầu vào, và trả lại giá trị xâu ký tự (Lưu ở app/src/res/values/strings.xml)
- Truyền **R.string.<key>** vào làm giá trị **id**

2.  

### Run to show 
1. With preview mode
   - In 3 tabs on the top-right of the screen: **Code**, **Split**, **Design**. Select **Split** then click 
   the build command to watch your code in preview mode. 
   - Or use short cut **Ctrl Shift F5** to see preview 
2. With physical devices
3. With emulators

### Errors and how to fix them 
1. **Dependency 'androidx.activity:activity:1.8.0' requires libraries or apps that depend on it to compile against 
version 34 or later of the Android APIs**.
    - In this case, we need to change **compileVersion** in **app/build.gradle.kts** from **33** to **34**
    - Then, sync gradle in the whole project
   
2. 

### Project best practices.
1. Nên đặt tên cho các kiểu biến số, các kiểu font chữ, màu sắc ... ở chung 1 chỗ theo kiểu khai báo các biến số và giá trị của chúng, 
dễ import, dễ sửa đổi và tăng tính đồng nhất. 
2. 
