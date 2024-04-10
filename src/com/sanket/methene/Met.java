package com.sanket.methene;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
public class Met extends JPanel        // methane average waves   
    {
  public static void main(String arg[])
 {
   JFrame frame = new JFrame("CH4 (methane-new)");     // set frame
   J2DPanel j2dpanel = new J2DPanel();
   frame.getContentPane().add(j2dpanel); frame.setSize(1180,700);
   frame.setVisible(true); frame.setBackground(Color.black);
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
  }
  }
 class J2DPanel extends JPanel implements ActionListener
  {
    
    double pai=3.141592653589793;      // pi=3.14
   double epsi=8.85418781787346e-12;   // permittivity
   double h=6.62606896e-34;           // Planck constant
   double elc=1.60217653e-19;         // electron charge
   double me=9.1093826e-31;           // electron mass
   double suh=5292.0*5292.0*1000.0;    // Bohr radius^2 x 1000

   int labe=0;                        // distinguish label             
   double nudis=10900.0;              // C-H nuclear distance
  
    JTextField elp[][]=new JTextField[8][11];  // text of electron 0-7
    JTextField elpp[][]=new JTextField[8][11]; // text after electron
    JTextField mmpho[][]=new JTextField[2][2]; // text nucleus H0 H2
    JTextField impho=new JTextField(7);       // text total V (eV)
    JTextField imphoo=new JTextField(7);    // text after total V
    
                                       // text average de Broglie waves
    JTextField averwa0=new JTextField(7);   // electron 0  average wave
    JTextField averwa4=new JTextField(7);   // electron 4 average wave
    JButton b1=new JButton("C-H (MM)");

    String ope[]={"8500","9000","9500","10000","10900","11400","12000","13000"};  
    JComboBox coom=new JComboBox(ope); 
     
    double rtw=Math.sqrt(2); double rth=Math.sqrt(3); 
    double rsi=Math.sqrt(6); double rfi=Math.sqrt(5);  
     double den=4.22;                 // den = central charge of carbon
    double hpr[][]=new double[8][11];    // each electron's parameter 
    double hpr3[][]=new double[8][11];   // ele0-3's symmetric position               
    double hprr[][]=new double[8][11];  // after electron parameter  
                                                               
    double hens = 6415.0;  double henr =(hens*2.0)/rsi;  
    double heno=(henr*rsi)/6.0; double hent=henr/rth; double henf=2.0*hent;

            // te1 = each electron initial coordinate wrt. each close nucleus                              
    double te1[][]={{hens, 0.0, 0.0}, {-heno, 0.0, henf}, 
    {-heno, -henr, -hent}, {-heno, henr, -hent}, 
    {0.0, 0.0, 4000.0}, {-1885.0, -3464.0, -666.0}, 
    {-1885.0, 2309.0, -2666.0}, {3771.0, 1154.0, -666.0}};

                           // te2= vector perpendicular to each C-H line
                           // te2 length = 10000
    double te2[][]={{0.0, 0.0, -10000.0}, {4714.0, 8660.3, 1666.7}, {4714.0,-5773.5,6666.7}, {-9428.1,-2886.8,1666.7}};


    double hen3=10900.0;  double henrr=(hen3*2.0)/rsi;     
                                              
    double hen1=(henrr*rsi)/6.0; double hen2=henrr/rth; double hen4=2.0*hen2;

              // nux[][x,y,z,charge] = each nucleus information   
              // nux[1-4][x,y,z] = eahc hydrogen nuclei and C-H vector

    double nux[][]={{0, 0, 0, den}, {hen3, 0, 0, 1}, {-hen1, 0, hen4, 1}, {-hen1, -henrr, -hen2, 1},{-hen1, henrr, -hen2,1}}; 

  double te3[][]=new double[8][4];  // te3 = perpendicular to C-H line and te2

  public J2DPanel()
 {
  setBackground(Color.black);
  JPanel p=new JPanel();
  p.setLayout(new GridLayout(19,12));
  int aaa=0; 
   double tx,ty,tz,tkk;
   for (int el=0; el <=3; el++) {  
    tx = te2[el][1]*nux[el+1][2]-te2[el][2]*nux[el+1][1];
    ty = te2[el][2]*nux[el+1][0]-te2[el][0]*nux[el+1][2];
    tz = te2[el][0]*nux[el+1][1]-te2[el][1]*nux[el+1][0];
    tkk = Math.sqrt(tx*tx+ty*ty+tz*tz);
    te3[el][0] = (tx*10000.0)/tkk;
    te3[el][1] = (ty*10000.0)/tkk;
    te3[el][2] = (tz*10000.0)/tkk;
   }
                               
  for (int el=0; el <=7; el++) {   
  for (int pos=0; pos <=2; pos++) {  // hpr[][0-2]=each electron's coordinate
  elp[el][pos]=new JTextField(7);     
  elpp[el][pos]=new JTextField(7);  
                      
  if (el==0 && pos==0) {elp[el][pos].addActionListener(this); }
  if (el==4 && pos==0) {elp[el][pos].addActionListener(this);}
  if (el==4 && pos==2) {elp[el][pos].addActionListener(this);}
  hpr[el][pos]=0.0;  hprr[el][pos]=0.0; hpr3[el][pos]=0.0;    
  }}
                                   
   for (int el=0; el <=7; el++) {
  for (int pos=3; pos <=10; pos++) {  // hpr[][3-10]=electron's other parameters
  elp[el][pos]=new JTextField(7);  elpp[el][pos]=new JTextField(7);  
  hpr[el][pos]=0.0;  hprr[el][pos]=0.0; hpr3[el][pos]=0.0;
  }}

   for (int el=0; el <=1; el++) {    // mmpho[0-1][]=H0 and H1 nuc's parameters
   for (int pos=0; pos <=1; pos++) {
    mmpho[el][pos]=new JTextField(7);
   }}

                                        // layout
  String sihy[]={"eNo ", "+X(MM)", "+Y(MM)", "+Z(MM)", "nuc(MM)", 
   "V(eV)", "tForce", "cforce ", "rforce",  "Waves", "  --  ", "  --  "};
  for (int el=0; el <=11; el++) {
   p.add(new Label(sihy[el]));
  }
 
  for (int el=0; el <=7; el++) {  
  if (el != 0 && el !=4 ) {     
  p.add(new Label("  "+el+" "));}
  if (el==0) {p.add(new Label("ele 0"));}
  if (el==4) {p.add(new Label("ele 4"));}
   
  for (int pos=0; pos <=10; pos++) {
  p.add(elp[el][pos]);
  }}

   p.add(new Label("H0 nuc ")); p.add(mmpho[0][0]); 
   p.add(new Label("H0 after ")); p.add(mmpho[0][1]); 
   p.add(new Label("total V ")); p.add(impho);
    p.add(new Label(" -- "));  p.add(new Label(" -- "));
   p.add(new Label("0-avewave "));  p.add(averwa0);
   p.add(new Label(" -- "));  p.add(new Label(" -- "));

   p.add(new Label("H1 nuc ")); p.add(mmpho[1][0]); 
   p.add(new Label("H1 after ")); p.add(mmpho[1][1]); 
   p.add(new Label("tV after")); p.add(imphoo);
    p.add(new Label(" -- "));  p.add(new Label(" -- "));
   p.add(new Label("4-avewave "));  p.add(averwa4);
    p.add(new Label(" -- "));  p.add(new Label(" -- "));
  
  for (int el=0; el <=6; el++) {  
  if (el != 0 && el !=4 ) {     
  p.add(new Label("af "+el+" "));}
  if (el==0) {p.add(new Label("afel 0"));}
  if (el==4) {p.add(new Label("afel 4"));}
   
  for (int pos=0; pos <=10; pos++) {
  p.add(elpp[el][pos]);
  }}

  p.add(new Label("af 7 "));
  for (int pos=0; pos <=8; pos++) {
  p.add(elpp[7][pos]);
  }
    p.add(b1); p.add(coom);

   coom.setSelectedItem("10900"); b1.addActionListener(this); 

   add(p,"South");

   double xx,yy,zz;
   for (int el=0; el <=7; el++) {

           // elp[el][3] = distance between each electron and close nucleus
   double nnuc=Math.sqrt(te1[el][0]*te1[el][0]+te1[el][1]*te1[el][1]+te1[el][2]*te1[el][2]);
      
   aaa=(int)(nnuc);

   elp[el][3].setText("nuc "+Integer.toString(aaa)); 
    for (int jou=0; jou <=2; jou++) {
    hpr[el][jou]=te1[el][jou]; 
    if (el > 3) { hpr[el][jou]=te1[el][jou] + nux[el-3][jou];}
                    // hpr[el][0-2] = absolute coordinate of each electron
    xx = te1[el][jou];
                    // elp[el][0-2] = relative coordinate of each electron 
    elp[el][jou].setText(Integer.toString((int)xx));
     }}
  }     // public J2DPanel() end
 

  public void actionPerformed(ActionEvent e) {  
    String ss;
    
     labe=0;
   if (e.getSource() == b1) {labe=4;}   // C-H button click
    
   if (labe == 4) {         
   ss=(String)coom.getSelectedItem();
    if (ss=="8500") {hen3=8500; }   if (ss=="9000") {hen3=9000; }
   if (ss=="10000") {hen3=10000;}  if (ss=="9500") {hen3=9500; } 
   if (ss=="10900") {hen3=10900; }  if (ss=="11400") {hen3=11400;}
   if (ss=="12000") {hen3=12000; }  if (ss=="13000") {hen3=13000;}

    henr=(hen3*2.0)/rsi;  nudis=hen3;   // hen3 = new CH distance  
                                               
    hen1=(henr*rsi)/6.0; hen2=henr/rth; hen4=2*hen2;

                                     // noxx[][0-2]= new nuclear coordinate
    double noxx[][]={{0.0,0.0,0.0}, {hen3, 0.0, 0.0}, {-hen1,0.0, hen4},
    {-hen1, -henr, -hen2},{-hen1, henr, -hen2}};

    for (int ett=0; ett <=4; ett++) {
     for (int sws=0; sws <=2; sws++) { 
     nux[ett][sws]=noxx[ett][sws];
    }}

    }   // if ( labe == 4 ) end
                                           
   repaint();
  }

  public void update(Graphics g)
 {
  paint(g);
 }
 public void paintComponent(Graphics g)
 {
   

  double kro,krr,krk,kwr,kww,kro2,krr2,krk2,kwr2,kww2,
  pot,pota,potb,potc,potd,gx,gy,gz,ggx,ggy,ggz,ttav,toav;
  int ex,ey,ez,xk,yk,zk; String ww,pxw,pyw;
  double rhp[][]= {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}};
  
  double rpp[][]= {{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},
  {0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0},{0,0,0,0,0,0,0}}; // after tra
  double mmp[][]={{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0}};  
  double mpp[][]={{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0}};          

 double teqq[][]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
   double teqqq[][]={{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};          
  kro2=0.0 ; krr2=0.0; krk2=0.0; kwr2=0.0; kww2=0.0;

  elp[0][1].setText(Integer.toString(0)); 
  elp[0][2].setText(Integer.toString(0)); 
  elp[4][1].setText(Integer.toString(0)); 
                             // get electron 0, 4 coordinates from textbox
                              
  ww=elp[0][0].getText(); hpr[0][0]=Double.parseDouble(ww);
  ww=elp[0][1].getText(); hpr[0][1]=Double.parseDouble(ww);
  ww=elp[0][2].getText(); hpr[0][2]=Double.parseDouble(ww);

  ww= elp[4][0].getText(); gx=Double.parseDouble(ww); hpr[4][0]=gx+nux[1][0];
  ww= elp[4][2].getText(); gz=Double.parseDouble(ww); 
  hpr[4][2] =gz + nux[1][2];

                 // set electron 1-3 coordinate based on electron 0
   for (int yp=1; yp <=3; yp++) {     
   for (int kj=0; kj <=2; kj++) {

   hpr[yp][kj] = (nux[yp+1][kj] * hpr[0][0])/nudis - (te2[yp][kj]*hpr[0][2])/10000.0 - (te3[yp][kj]*hpr[0][1])/10000.0;       
   elp[yp][kj].setText(Integer.toString((int)hpr[yp][kj]));
   }} 

                 // set electron 5-7 coordinates based on electron 4 
   for (int yp=5; yp <=7; yp++) {     
   for (int kj=0; kj <=2; kj++) {

   hpr[yp][kj] = (nux[yp-3][kj] * gx)/nudis - (te2[yp-4][kj]*gz)/10000.0;       
   elp[yp][kj].setText(Integer.toString((int)hpr[yp][kj]));
   hpr[yp][kj] = hpr[yp][kj] + nux[yp-3][kj];
   }} 
          // hpr3[][0-2] = symmetric position of electron 0-3 wrt. C nucleus
    for (int yp=0; yp <=3; yp++) {    
   for (int kj=0; kj <=2; kj++) {

   hpr3[yp][kj] = -hpr[yp][kj];
    }}

    toav=0.0; ggy=0.0;             // toav=total potential energy (eV)

    double ppot;
    for (int yp=0; yp <=7; yp++) {      // interaction between electrons 0-7    
    for (int kj=0; kj <=7; kj++) { 
    if (yp < kj ) {                  // kro=distance (MM) between electrons
    kro=Math.sqrt((hpr[yp][0]-hpr[kj][0])*(hpr[yp][0]-hpr[kj][0])+
   (hpr[yp][1]-hpr[kj][1])*(hpr[yp][1]-hpr[kj][1])+
   (hpr[yp][2]-hpr[kj][2])*(hpr[yp][2]-hpr[kj][2]));

   if (kro==0) {kro=5000.0;}      // ppot = each potential energy (eV)
   ppot=(elc*elc*6.241509e18)/(4.0*pai*epsi*kro*1.0e-14);

     if (yp < 4 && kj < 4 ) {    // teqq[el 0-3][3] = only carbon atom V
     teqq[yp][3]=teqq[yp][3]+ppot/2.0;
     teqq[kj][3]=teqq[kj][3]+ppot/2.0;
   }
                   // kro2 = distance between symmetric ele0-3 and ele4-7
   if ( yp < 4 && kj > 3  ) {
    kro2 = Math.sqrt((hpr3[yp][0]-hpr[kj][0])*(hpr3[yp][0]-hpr[kj][0])+
   (hpr3[yp][1]-hpr[kj][1])*(hpr3[yp][1]-hpr[kj][1])+
   (hpr3[yp][2]-hpr[kj][2])*(hpr3[yp][2]-hpr[kj][2]));
    ppot=ppot*0.5;
    potd =(elc*elc*6.241509e18*0.5)/(4*pai*epsi*kro2*1.0e-14); 
    ppot = ppot + potd;
    }   
                     // rhp[el][3] = each electron potential energy
   rhp[yp][3]=rhp[yp][3]+ppot/2.0;  rhp[kj][3]=rhp[kj][3]+ppot/2.0;

   toav=toav+ppot;

     for (int jou=0; jou <=2; jou++) {
                          //ggx =  force between each electron
   ggx=(suh*(hpr[yp][jou]-hpr[kj][jou]))/(kro*kro*kro); ggz=ggx;


   if ( yp < 4 && kj > 3  ) {
    ggy=(suh*(hpr3[yp][jou]-hpr[kj][jou]))/(kro2*kro2*kro2);
    ggx=ggx*0.5;
    ggx = ggx + (0.5 * ggy);
    }

                   // rhp[][0-2]=force component acting on each electron 
   rhp[yp][jou]=rhp[yp][jou]+ggz;  rhp[kj][jou]=rhp[kj][jou]-ggx;

     

    }
    }}}

   
                        // interaction between electron and each nucleus
                                 
   for (int yp=0; yp <=7; yp++) {   
   for (int rv=0; rv <=4; rv++) {       
                                      
   kro=Math.sqrt((hpr[yp][0]-nux[rv][0])*(hpr[yp][0]-nux[rv][0])+
   (hpr[yp][1]-nux[rv][1])*(hpr[yp][1]-nux[rv][1])+
   (hpr[yp][2]-nux[rv][2])*(hpr[yp][2]-nux[rv][2])); 
     if (kro == 0) {kro=5000.0;}
                         // ppot = potential energy between nuc and ele
     ppot=-(nux[rv][3]*elc*elc*6.241509e18)/(4.0*pai*epsi*kro*1.0e-14);

                          // teqq[][3] = V only in carbon atom
       if (rv==0 && yp < 4 ) {  teqq[yp][3]=teqq[yp][3]+ppot;     }

   if ( yp < 4   ) {
     
    kro2 = Math.sqrt((hpr3[yp][0]-nux[rv][0])*(hpr3[yp][0]-nux[rv][0])+
   (hpr3[yp][1]-nux[rv][1])*(hpr3[yp][1]-nux[rv][1])+
   (hpr3[yp][2]-nux[rv][2])*(hpr3[yp][2]-nux[rv][2]));
      potd=-(0.5*nux[rv][3]*elc*elc*6.241509e18)/(4*pai*epsi*kro2*1.0e-14);
      ppot=(ppot*0.5)+potd;
   
    }

     toav = toav + ppot; rhp[yp][3] = rhp[yp][3] + ppot;

    if ( yp < 4 ) {
       if ( rv > 0 ) {
      rhp[yp][6] = rhp[yp][6] + ppot;
      }}
              // rhp[el][6] = V (eV) between each electron and other nuclei
    if ( yp > 3 ) {
        zk = yp -3;   
       if ( rv != zk ) { rhp[yp][6] = rhp[yp][6] + ppot;}                    
       }

       for (int jou=0; jou <=2; jou++) {        // force component
      ggx=(suh*nux[rv][3]*(hpr[yp][jou]-nux[rv][jou]))/(kro*kro*kro);
      ggz=ggx;

      
     if ( yp < 4   ) {
        ggy=(0.5*suh*nux[rv][3]*(hpr3[yp][jou]-nux[rv][jou]))/(kro2*kro2*kro2);
        ggx=(0.5*ggx) + ggy;
        }
                                              
  rhp[yp][jou] = rhp[yp][jou] - ggz; 
  mmp[rv][jou] = mmp[rv][jou] + ggx; 
       }            // mmp[nuc][0-2] = force component acting on each nucleus
               
    }}                               //  interaction ele-nuc end

                              // interactions among nuclei
    pota = 0.0;                       // pota = potential V among nuclei
    for (int yp=0; yp <=4; yp++) {       
    for (int kj=0; kj <=4; kj++) { 
    if (yp < kj ) {                         
     kro = Math.sqrt((nux[yp][0]-nux[kj][0])*(nux[yp][0]-nux[kj][0]) +  (nux[yp][1]-nux[kj][1])*(nux[yp][1]-nux[kj][1]) + (nux[yp][2]-nux[kj][2])*(nux[yp][2]-nux[kj][2])  );
      if (kro == 0) {kro=5000.0;}
    ppot = (nux[yp][3]*nux[kj][3]*elc*elc*6.241509e18)/(4.0*pai*epsi*kro*1.0e-14);
    toav=toav+ppot;  pota=pota+ppot;
    
      for (int jou=0; jou <=2; jou++) {
         ggx=(suh*nux[yp][3]*nux[kj][3]*(nux[yp][jou]-nux[kj][jou]))/(kro*kro*kro);
         mmp[yp][jou] = mmp[yp][jou] + ggx; mmp[kj][jou] = mmp[kj][jou] - ggx; 
         mmp[yp][jou+3] = mmp[yp][jou+3] + ggx; mmp[kj][jou+3] = mmp[kj][jou+3] - ggx;
              // mmp[nuc][3-5] = force component only among nuclei
                                                  
     }
     }}}                   
                            // show total V to two decimal places
   ex=(int)(toav*100.0);  ggx=ex/100.0;
   impho.setText("tV "+Double.toString(ggx));                                                                      
       gz = 0.0;                             
       for (int yp=0; yp <=7; yp++) {
        gz = gz + rhp[yp][6];
        }

         // distribute V only among nuclei to each electron based on rhp[el][6]

       for (int yp=0; yp <=7; yp++) {
        rhp[yp][3] = rhp[yp][3] + (pota * rhp[yp][6])/gz;
        }
                                                    // show electron 0-3 data
     for (int yp=0; yp <=3; yp++) {
     ex=(int)(rhp[yp][3]*100.0);  ggx=ex/100.0;
     elp[yp][4].setText("V "+Double.toString(ggx));  //show electron 0-3 's V

     kro = Math.sqrt(hpr[yp][0]*hpr[yp][0]+hpr[yp][1]*hpr[yp][1]+hpr[yp][2]*hpr[yp][2]);
     if (kro == 0) {kro=5000.0;}
     ex=(int)(kro);  
                   // show distance betwee C nucleus and ele 0-3
     elp[yp][3].setText("nuc "+Integer.toString(ex));  

                  // inner product of rhp(= force) and nux (= CH line )
     rhp[yp][4] = -(nux[yp+1][0]*rhp[yp][0] +nux[yp+1][1]*rhp[yp][1] + nux[yp+1][2]*rhp[yp][2])/nudis;
     rhp[yp][5] = 0.0;     
                    // cf = force acting on ele 0-3  toward C nucleus   
     ex=(int)(rhp[yp][4]);  
     elp[yp][5].setText("tF "+Integer.toString(ex));
     elp[yp][6].setText("cf "+Integer.toString(ex));
     elp[yp][7].setText("rf "+Integer.toString(0));
      }
          
                                                  // show electron 4-7 data
     for (int yp=4; yp <=7; yp++) {
     ex=(int)(rhp[yp][3]*100.0);  ggx=ex/100.0;
     elp[yp][4].setText("V "+Double.toString(ggx));  //show electron 4-7 's V

     kro=Math.sqrt((hpr[yp][0]-nux[yp-3][0])*(hpr[yp][0]-nux[yp-3][0])+
    (hpr[yp][1]-nux[yp-3][1])*(hpr[yp][1]-nux[yp-3][1])+
    (hpr[yp][2]-nux[yp-3][2])*(hpr[yp][2]-nux[yp-3][2])); 
     if (kro == 0) {kro=5000.0;}
     ex=(int)(kro);  
     elp[yp][3].setText("nuc "+Integer.toString(ex));  

                    // rhp[ele 4-7][4] = force acting on ele 4-7  toward C nuc
     rhp[yp][4] = -(nux[yp-3][0]*rhp[yp][0] +nux[yp-3][1]*rhp[yp][1] + nux[yp-3][2]*rhp[yp][2])/nudis;

                // rhp[ele 4-7][5] = force acting on ele 4-7  toward C-H line

      rhp[yp][5] = (te2[yp-4][0]*rhp[yp][0] +te2[yp-4][1]*rhp[yp][1] + te2[yp-4][2]*rhp[yp][2])/10000.0;
     if ( hpr[4][2] < 0 ) { 
         rhp[yp][5] = -(te2[yp-4][0]*rhp[yp][0] +te2[yp-4][1]*rhp[yp][1] + te2[yp-4][2]*rhp[yp][2])/10000.0;
         }
 
                 // gx = total force acting on each electron
       gx=Math.sqrt(rhp[yp][0]*rhp[yp][0]+rhp[yp][1]*rhp[yp][1]+rhp[yp][2]*rhp[yp][2]);
        ex=(int)(gx);  
     elp[yp][5].setText("tF "+Integer.toString(ex));      // total force on ele4-7
        ex=(int)(rhp[yp][4]);  
   if (yp ==4 ) {                            // show cf force
     elp[yp][6].setText("cf "+Integer.toString(ex)+"   *");}   
     else { elp[yp][6].setText("cf "+Integer.toString(ex));  }
        ex=(int)(rhp[yp][5]);  
     elp[yp][7].setText("rf "+Integer.toString(ex));      // r-force ele 4-7

     }
                                     // show electron 4-7 de Broglie waves
 
      for (int yp=4; yp <=7; yp++) {   
                                   // gz = total force acting on each electron 
     gz = Math.sqrt(rhp[yp][0]*rhp[yp][0]+rhp[yp][1]*rhp[yp][1]+rhp[yp][2]*rhp[yp][2]);
     gy=(gz*elc*elc)/(4*pai*epsi*suh*1.0e-28);    // change  gz to force (N)
     gx=Math.sqrt((-1.0*rhp[yp][3]*1.602177e-19)/me);  // gx=velocity (m/s)
                                                // Virial 2T = - V

     ggx=(me*gx*gx)/gy;          // ggx="temporary" rotation radius
                           // ggy=de Broglie's waves included in one orbit
     ggy=(2*pai*ggx*me*gx)/h;   
     hpr[yp][3]=ggy;                          // hpr[][3] = waves 
     ex=(int)(ggy*1000);  ggy=ex/1000.0;
                                     // show de Broglie wave number
     elp[yp][8].setText("wn "+Double.toString(ggy)); 
      }

                                        // electron 0-3 de Broglie wave

     kro=Math.sqrt(hpr[0][0]*hpr[0][0]+hpr[0][1]*hpr[0][1]+hpr[0][2]*hpr[0][2]);     double ra=(kro*2)/rsi;
     gy=(elc*elc)/(4.0*pai*epsi*ra*ra*1.0e-28) *(-rsi/4.0+(2.0*den)/3.0);
                      //  gy = force (N) acting on each electron (tetradedron)

     
     for (int yp=0; yp <=3; yp++) {

     gx=Math.sqrt((-1.0*teqq[yp][3]*1.602177e-19)/me);  // gx=velocity (m/s)
     ggx=(me*gx*gx)/gy;          
     ggy=(2*pai*ggx*me*gx)/h;     // de Broglie waves in one orbit                  
     hpr[yp][3]=ggy;  
     ex=(int)(ggy*1000);  ggy=ex/1000.0;
     elp[yp][8].setText("wn "+Double.toString(ggy));                        
     }
                                                   
                         // show force acting on H0 H1 nuclei toward C 
     for (int rv=1; rv <=2; rv++) {
      gx = -(nux[rv][0]*mmp[rv][0] +nux[rv][1]*mmp[rv][1] + nux[rv][2]*mmp[rv][2])/nudis;      
      ex=(int)(gx);
      mmpho[rv-1][0].setText("CF "+Integer.toString(ex));
      }
                                             // upper table ends


             // vvh[0-4][0-2] = vector toward ( perpendicular to ) each CH line

    double vvh[][]=new double[4][6];    
    for (int yp=4; yp <=7; yp++) { 
                
                 // inner product hpr and nux (CH line)
    kro=(hpr[yp][0]*nux[yp-3][0]+hpr[yp][1]*nux[yp-3][1]+hpr[yp][2]*nux[yp-3][2])/nudis;
   for (int kj=0; kj <=2; kj++) { 
    vvh[yp-4][kj] = (nux[yp-3][kj]*kro)/nudis; 
    vvh[yp-4][kj] = vvh[yp-4][kj] - hpr[yp][kj];  
     }

     krr = Math.sqrt( vvh[yp-4][0]*vvh[yp-4][0]+vvh[yp-4][1]*vvh[yp-4][1]+ vvh[yp-4][2]*vvh[yp-4][2] );
                  // gx = vector toward C nuclues wrt force component
      gx = rhp[yp][4] * krr  / rhp[yp][5];
    for (int kj=0; kj <=2; kj++) {
      vvh[yp-4][kj+3]  = -(nux[yp-3][kj] * gx)/nudis;  
     }}
 
                     // another electron coordinate after transformation   

     for (int yp=0; yp <=3; yp++) {
     for (int jou=0; jou <=2; jou++) {
       hprr[yp][jou] = hpr[yp][jou];
        } }
            
       // hprr[4-7][0-2] = electron 4-7 coordinate after moving following force

    for (int yp=4; yp <=7; yp++) {
    for (int kj=0; kj <=2; kj++) {
     
     hprr[yp][kj] = hpr[yp][kj] + vvh[yp-4][kj+3] * 2.0 ;   
     }}
           

     hprr[4][1] = 0.0;

     for (int yp=0; yp <=3; yp++) {    // set elpp[0-3][0-2] = after ele0-3 
     for (int kj=0; kj <=2; kj++) {
  
     elpp[yp][kj].setText(Integer.toString((int)hprr[yp][kj]));
     }} 

   
   
   for (int yp=4; yp <=7; yp++) {  // set elpp[4-7][0-2] = after ele 4-7 
   for (int kj=0; kj <=2; kj++) {
          
      gx = hprr[yp][kj] - nux[yp-3][kj];
      elpp[yp][kj].setText(Integer.toString((int)gx));

     }}
    

    toav=0.0;                 // toav= total V after moving

    for (int yp=0; yp <=7; yp++) {   // interaction between after ele 0-7    
    for (int kj=0; kj <=7; kj++) { 
    if (yp < kj ) {                    // kro=distance between electrons
    kro=Math.sqrt((hprr[yp][0]-hprr[kj][0])*(hprr[yp][0]-hprr[kj][0])+
   (hprr[yp][1]-hprr[kj][1])*(hprr[yp][1]-hprr[kj][1])+
   (hprr[yp][2]-hprr[kj][2])*(hprr[yp][2]-hprr[kj][2]));

   if (kro==0) {kro=5000.0;}      // ppot = each potential energy (eV)
   ppot=(elc*elc*6.241509e18)/(4*pai*epsi*kro*1.0e-14);

   if ( yp < 4 && kj < 4) {
        teqqq[yp][3]=teqqq[yp][3]+ppot/2.0; 
        teqqq[kj][3]=teqqq[kj][3]+ppot/2.0;
     }                    // teqqq[0-3][3] = V only in carbon atom 

               // between (symmetric) electron0-3 and 4-7
   if ( yp < 4 && kj > 3 ) {
    kro2=Math.sqrt((hpr3[yp][0]-hprr[kj][0])*(hpr3[yp][0]-hprr[kj][0])+
   (hpr3[yp][1]-hprr[kj][1])*(hpr3[yp][1]-hprr[kj][1])+
   (hpr3[yp][2]-hprr[kj][2])*(hpr3[yp][2]-hprr[kj][2]));
    potd = (0.5*elc*elc*6.241509e18)/(4*pai*epsi*kro2*1.0e-14);
   ppot = (ppot*0.5) + potd;
    }                    
                       // rpp[0-7][3] = each V of electron after moving
                      
   rpp[yp][3]=rpp[yp][3]+ppot/2.0;  rpp[kj][3]=rpp[kj][3]+ppot/2.0;
   toav=toav+ppot;

                      // force component between electrons
     for (int jou=0; jou <=2; jou++) {
   ggx=(suh*(hprr[yp][jou]-hprr[kj][jou]))/(kro*kro*kro); ggz=ggx;

      if ( yp < 4 && kj > 3 ) {
    ggy = (0.5*suh*(hpr3[yp][jou]-hprr[kj][jou]))/(kro2*kro2*kro2);
    ggx = (ggx*0.5)+ggy ;

    }
                            
   rpp[yp][jou]=rpp[yp][jou]+ggz;  rpp[kj][jou]=rpp[kj][jou]-ggx;
    }
    }}}

   
                    // interaction between after ele and each nucleus
                                 
   for (int yp=0; yp <=7; yp++) {   
   for (int rv=0; rv <=4; rv++) {       
                                      
   kro=Math.sqrt((hprr[yp][0]-nux[rv][0])*(hprr[yp][0]-nux[rv][0])+
   (hprr[yp][1]-nux[rv][1])*(hprr[yp][1]-nux[rv][1])+
   (hprr[yp][2]-nux[rv][2])*(hprr[yp][2]-nux[rv][2])); 
     if (kro == 0) {kro=5000.0;}
     ppot=-(nux[rv][3]*elc*elc*6.241509e18)/(4.0*pai*epsi*kro*1.0e-14);

                           // teqqq[0-3][3] = V only in carbon
    if (rv==0 && yp < 4 ) { teqqq[yp][3]=teqqq[yp][3]+ppot;    }

    if ( yp < 4 )   {

     kro2=Math.sqrt((hpr3[yp][0]-nux[rv][0])*(hpr3[yp][0]-nux[rv][0])+
   (hpr3[yp][1]-nux[rv][1])*(hpr3[yp][1]-nux[rv][1])+
   (hpr3[yp][2]-nux[rv][2])*(hpr3[yp][2]-nux[rv][2])); 
    potd = -(0.5*nux[rv][3]*elc*elc*6.241509e18)/(4*pai*epsi*kro2*1.0e-14);
   ppot = (0.5*ppot) + potd;
    }

     toav = toav + ppot; rpp[yp][3] = rpp[yp][3] + ppot;

                  // rpp[el][6]= V between each electron and other nuclei
     if ( yp < 4 ) {
       if ( rv > 0 ) {
      rpp[yp][6] = rpp[yp][6] + ppot;
      }}

    if ( yp > 3 ) {
        zk = yp -3;   
       if ( rv != zk ) { rpp[yp][6] = rpp[yp][6] + ppot;}                    
       }

                      // force component between electron and nuclei
      for (int jou=0; jou <=2; jou++) {        
      ggx=(suh*nux[rv][3]*(hprr[yp][jou]-nux[rv][jou]))/(kro*kro*kro);
      ggz=ggx;
         
      if ( yp < 4 )  {
       
       ggy = (0.5* suh*nux[rv][3]*(hpr3[yp][jou]-nux[rv][jou]))/(kro2*kro2*kro2);
       ggx = (0.5*ggx) + ggy;
       }
                                         
  rpp[yp][jou] = rpp[yp][jou] - ggz; mpp[rv][jou] = mpp[rv][jou] + ggx;
       }            
    }}                          

     toav = toav + pota;
     for (int rv=0; rv <=4; rv++) { 
     for (int jou=0; jou <=2; jou++) { 
       mpp[rv][jou]=mpp[rv][jou]+mmp[rv][jou+3];
     }}
     
                   // distribute nucler V to electron based on rhp[][6]
      gz = 0.0;        
       for (int yp=0; yp <=7; yp++) {
        gz = gz + rpp[yp][6];
        }

       for (int yp=0; yp <=7; yp++) {
        rpp[yp][3] = rpp[yp][3] + (pota * rpp[yp][6])/gz;
        }

   ex=(int)(toav*100.0);  ggx=ex/100.0;
   imphoo.setText("tV "+Double.toString(ggx));      // show after tV 


                                                    // show after elec 0-3 data
     for (int yp=0; yp <=3; yp++) {
     ex=(int)(rpp[yp][3]*100.0);  ggx=ex/100.0;
     elpp[yp][4].setText("V "+Double.toString(ggx));  //show after ele 0-3 's V

     kro = Math.sqrt(hprr[yp][0]*hprr[yp][0]+hprr[yp][1]*hprr[yp][1]+hprr[yp][2]*hprr[yp][2]);
     if (kro == 0) {kro=5000.0;}
     ex=(int)(kro);  
     elpp[yp][3].setText("nuc "+Integer.toString(ex));  
     rpp[yp][4] = -(nux[yp+1][0]*rpp[yp][0] +nux[yp+1][1]*rpp[yp][1] + nux[yp+1][2]*rpp[yp][2])/nudis;
     rpp[yp][5] = 0.0;      // cf = force acting on ele toward C nucleus
     ex=(int)(rpp[yp][4]);  
     elpp[yp][5].setText("tF "+Integer.toString(ex));
     elpp[yp][6].setText("cf "+Integer.toString(ex));
     elpp[yp][7].setText("rf "+Integer.toString(0));
      }
          
                                                  // show after ele 4-7 data
     for (int yp=4; yp <=7; yp++) {
     ex=(int)(rpp[yp][3]*100.0);  ggx=ex/100.0;
     elpp[yp][4].setText("V "+Double.toString(ggx));  //show after ele 4-7 's V

     kro=Math.sqrt((hprr[yp][0]-nux[yp-3][0])*(hprr[yp][0]-nux[yp-3][0])+
    (hprr[yp][1]-nux[yp-3][1])*(hprr[yp][1]-nux[yp-3][1])+
    (hprr[yp][2]-nux[yp-3][2])*(hprr[yp][2]-nux[yp-3][2])); 
     if (kro == 0) {kro=5000.0;}
     ex=(int)(kro);  
     elpp[yp][3].setText("nuc "+Integer.toString(ex)); 

                            
     rpp[yp][4] = -(nux[yp-3][0]*rpp[yp][0] +nux[yp-3][1]*rpp[yp][1] + nux[yp-3][2]*rpp[yp][2])/nudis;
      rpp[yp][5] = (te2[yp-4][0]*rpp[yp][0] +te2[yp-4][1]*rpp[yp][1] + te2[yp-4][2]*rpp[yp][2])/10000.0;

    if ( hprr[4][2] < 0 ) {
      rpp[yp][5] = -(te2[yp-4][0]*rpp[yp][0] +te2[yp-4][1]*rpp[yp][1] + te2[yp-4][2]*rpp[yp][2])/10000.0;
         }
       gx=Math.sqrt(rpp[yp][4]*rpp[yp][4]+rpp[yp][5]*rpp[yp][5]);
        ex=(int)(gx);  
     elpp[yp][5].setText("tF "+Integer.toString(ex));  // total force    
        ex=(int)(rpp[yp][4]);  
     if (yp ==4 ) {                            // show cf force
     elpp[yp][6].setText("cf "+Integer.toString(ex)+"   *");}   
     else { elpp[yp][6].setText("cf "+Integer.toString(ex));  }  
        ex=(int)(rpp[yp][5]);  
     elpp[yp][7].setText("rf "+Integer.toString(ex));     

     }
                               // show after ele 4-7 de Broglie waves
 
      for (int yp=4; yp <=7; yp++) {    
     gz = Math.sqrt(rpp[yp][0]*rpp[yp][0]+rpp[yp][1]*rpp[yp][1]+rpp[yp][2]*rpp[yp][2]);
     gy=(gz*elc*elc)/(4*pai*epsi*suh*1.0e-28);    // gy=force (N)
     gx=Math.sqrt((-1.0*rpp[yp][3]*1.602177e-19)/me);  // gx=velocity (m/s)

     ggx=(me*gx*gx)/gy;          // ggx="temporary" radius
     ggy=(2*pai*ggx*me*gx)/h;          // ggy=de Broglie's waves in one orbit
     hprr[yp][3]=ggy;                       // hpr[][3] = waves 
     ex=(int)(ggy*1000);  ggy=ex/1000.0;
     elpp[yp][8].setText("wn "+Double.toString(ggy)); 
      }

                                  //   ele 0-3 de Broglie wave

     kro=Math.sqrt(hpr[0][0]*hpr[0][0]+hpr[0][1]*hpr[0][1]+hpr[0][2]*hpr[0][2]);      ra=(kro*2.0)/rsi;
     gy=(elc*elc)/(4.0*pai*epsi*ra*ra*1.0e-28) *(-rsi/4.0+(2.0*den)/3.0);
                  // gy= force toward C acting on each ele0-4 (= tetrahedron)

     for (int yp=0; yp <=3; yp++) {
     gx=Math.sqrt((-1.0*teqqq[yp][3]*1.602177e-19)/me);  // gx=velocity (m/s)
     ggx=(me*gx*gx)/gy;          
     ggy=(2*pai*ggx*me*gx)/h;                  
     hprr[yp][3]=ggy;   
     ex=(int)(ggy*1000);  ggy=ex/1000.0;
     elpp[yp][8].setText("wn "+Double.toString(ggy));                       
     }
        
                                                   
                               // show force acting on H0 H1 nuclei toward C 
     for (int rv=1; rv <=2; rv++) {
      gx = -(nux[rv][0]*mpp[rv][0] +nux[rv][1]*mpp[rv][1] + nux[rv][2]*mpp[rv][2])/nudis;      
      ex=(int)(gx);
      mmpho[rv-1][1].setText("aCF "+Integer.toString(ex));
      }
 
               // show average de Broglie waves before and after moving
                                             
      gx = (hpr[0][3]+hprr[0][3])/2.0; 
      ex=(int)(gx*1000);  gx=ex/1000.0;
      averwa0.setText("wn "+Double.toString(gx)); 

      gx = (hpr[4][3]+hprr[4][3])/2.0; 
      ex=(int)(gx*1000);  gx=ex/1000.0;
      averwa4.setText("wn "+Double.toString(gx)); 
                                                
   }
   }

