package com.szumal.tumblrviewer;

import android.os.AsyncTask;

import org.w3c.dom.Attr;
import org.w3c.dom.CDATASection;
import org.w3c.dom.Comment;
import org.w3c.dom.DOMConfiguration;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.EntityReference;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.ProcessingInstruction;
import org.w3c.dom.Text;
import org.w3c.dom.UserDataHandler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by szuma on 24.01.2018.
 */

public class AsyncPost extends AsyncTask<String, Void, Document> {

    @Override
    protected Document doInBackground(String... userName) {


        Document doc = new Document() {
            @Override
            public DocumentType getDoctype() {
                return null;
            }

            @Override
            public DOMImplementation getImplementation() {
                return null;
            }

            @Override
            public Element getDocumentElement() {
                return null;
            }

            @Override
            public Element createElement(String s) throws DOMException {
                return null;
            }

            @Override
            public DocumentFragment createDocumentFragment() {
                return null;
            }

            @Override
            public Text createTextNode(String s) {
                return null;
            }

            @Override
            public Comment createComment(String s) {
                return null;
            }

            @Override
            public CDATASection createCDATASection(String s) throws DOMException {
                return null;
            }

            @Override
            public ProcessingInstruction createProcessingInstruction(String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttribute(String s) throws DOMException {
                return null;
            }

            @Override
            public EntityReference createEntityReference(String s) throws DOMException {
                return null;
            }

            @Override
            public NodeList getElementsByTagName(String s) {
                return null;
            }

            @Override
            public Node importNode(Node node, boolean b) throws DOMException {
                return null;
            }

            @Override
            public Element createElementNS(String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttributeNS(String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public NodeList getElementsByTagNameNS(String s, String s1) {
                return null;
            }

            @Override
            public Element getElementById(String s) {
                return null;
            }

            @Override
            public String getInputEncoding() {
                return null;
            }

            @Override
            public String getXmlEncoding() {
                return null;
            }

            @Override
            public boolean getXmlStandalone() {
                return false;
            }

            @Override
            public void setXmlStandalone(boolean b) throws DOMException {

            }

            @Override
            public String getXmlVersion() {
                return null;
            }

            @Override
            public void setXmlVersion(String s) throws DOMException {

            }

            @Override
            public boolean getStrictErrorChecking() {
                return false;
            }

            @Override
            public void setStrictErrorChecking(boolean b) {

            }

            @Override
            public String getDocumentURI() {
                return null;
            }

            @Override
            public void setDocumentURI(String s) {

            }

            @Override
            public Node adoptNode(Node node) throws DOMException {
                return null;
            }

            @Override
            public DOMConfiguration getDomConfig() {
                return null;
            }

            @Override
            public void normalizeDocument() {

            }

            @Override
            public Node renameNode(Node node, String s, String s1) throws DOMException {
                return null;
            }

            @Override
            public String getNodeName() {
                return null;
            }

            @Override
            public String getNodeValue() throws DOMException {
                return null;
            }

            @Override
            public void setNodeValue(String s) throws DOMException {

            }

            @Override
            public short getNodeType() {
                return 0;
            }

            @Override
            public Node getParentNode() {
                return null;
            }

            @Override
            public NodeList getChildNodes() {
                return null;
            }

            @Override
            public Node getFirstChild() {
                return null;
            }

            @Override
            public Node getLastChild() {
                return null;
            }

            @Override
            public Node getPreviousSibling() {
                return null;
            }

            @Override
            public Node getNextSibling() {
                return null;
            }

            @Override
            public NamedNodeMap getAttributes() {
                return null;
            }

            @Override
            public Document getOwnerDocument() {
                return null;
            }

            @Override
            public Node insertBefore(Node node, Node node1) throws DOMException {
                return null;
            }

            @Override
            public Node replaceChild(Node node, Node node1) throws DOMException {
                return null;
            }

            @Override
            public Node removeChild(Node node) throws DOMException {
                return null;
            }

            @Override
            public Node appendChild(Node node) throws DOMException {
                return null;
            }

            @Override
            public boolean hasChildNodes() {
                return false;
            }

            @Override
            public Node cloneNode(boolean b) {
                return null;
            }

            @Override
            public void normalize() {

            }

            @Override
            public boolean isSupported(String s, String s1) {
                return false;
            }

            @Override
            public String getNamespaceURI() {
                return null;
            }

            @Override
            public String getPrefix() {
                return null;
            }

            @Override
            public void setPrefix(String s) throws DOMException {

            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public boolean hasAttributes() {
                return false;
            }

            @Override
            public String getBaseURI() {
                return null;
            }

            @Override
            public short compareDocumentPosition(Node node) throws DOMException {
                return 0;
            }

            @Override
            public String getTextContent() throws DOMException {
                return null;
            }

            @Override
            public void setTextContent(String s) throws DOMException {

            }

            @Override
            public boolean isSameNode(Node node) {
                return false;
            }

            @Override
            public String lookupPrefix(String s) {
                return null;
            }

            @Override
            public boolean isDefaultNamespace(String s) {
                return false;
            }

            @Override
            public String lookupNamespaceURI(String s) {
                return null;
            }

            @Override
            public boolean isEqualNode(Node node) {
                return false;
            }

            @Override
            public Object getFeature(String s, String s1) {
                return null;
            }

            @Override
            public Object setUserData(String s, Object o, UserDataHandler userDataHandler) {
                return null;
            }

            @Override
            public Object getUserData(String s) {
                return null;
            }
        };
        String uri =
                "https://" + userName[0] + ".tumblr.com/api/read";

        try {
            URL url = new URL(uri);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/xml");

            InputStream xml = connection.getInputStream();

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(xml);
            doc.getDocumentElement().normalize();

            //System.out.println("ZYX: " + uri.toString());
        }catch (Exception e){

        }

        return doc;

    }
}
